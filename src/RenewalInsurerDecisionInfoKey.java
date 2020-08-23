import java.lang.reflect.Field;
import java.util.ArrayList;

public final class RenewalInsurerDecisionInfoKey extends Object {
    public boolean IsAuto = false;
    public boolean IsRebroked = false;
    public boolean IsIncumbent = false;
    public boolean IsIncumbentDeclined = false;
    public boolean newColumn = false;

    public RenewalInsurerDecisionInfoKey build(RenewalInsurerDecisionInfo decisionInfo, int listSize, boolean isIncumbentDeclined) {
        this.IsAuto = listSize == 1;
        this.IsRebroked = decisionInfo.IsRebroked;
        this.IsIncumbent = decisionInfo.IsIncumbent;
        this.IsIncumbentDeclined = isIncumbentDeclined;
        this.newColumn = decisionInfo.newColumn;
        return this;
    }

    private Object[] getFieldValues(Object obj) {
        ArrayList<Object> values = new ArrayList<Object>();
        Field[] fields = obj.getClass().getFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                values.add(fields[i].get(obj));
            }
        }
        catch (IllegalAccessException exception) {
            return new Object[0];
        }
        return values.toArray();
    }

    @Override
    public int hashCode() {
        // Build the binary representation of the boolean values of the class
//        int bit3 = (Boolean.hashCode(IsAuto) == 1231 ? 1 : 0) << 3;
//        int bit2 = (Boolean.hashCode(IsRebroked)  == 1231 ? 1 : 0) << 2;
//        int bit1 = (Boolean.hashCode(IsIncumbent) == 1231 ? 1 : 0) << 1;
//        int bit0 = Boolean.hashCode(IsIncumbentDeclined) == 1231 ? 1 : 0;
        /**
         * For example below will be the result if the member variables are set as follows:
         * true, false, true, true
         * 1     0      1     1    = 14
         */
        return generatedHashCode(getFieldValues(this));
    }

    /**
     *  Builds the hashcode for this object by creating a binary number (returned as an int) using the
     *  current values of all the Fields for this object.
     *
     *  This can then be used to confirm if two of <code>this</code> object are
     *  logically equivalent.
     *
     *  Because the Fields are all booleans, they are effectively a bit.
     *  So the binary representation is created by shifting the bit left by the
     *  index of the array.
     *
     * E.g. true, false, true, true
     *   3: 1     0      0     0
     *   2: 0     0      0     0
     *   1: 0     0      1     0
     *   0: 0     0      0     1
     *      --------------------  logical OR
     *      1     0      1     1    = 11
     *
     * @param fieldValues - Array containing the current values of the Fields for <code>this</code> object
     * @return - The int representation of the binary number created
     */
    private int generatedHashCode(Object[] fieldValues) {
        int hashCode = 0;
        for (int i = fieldValues.length - 1; i >= 0; i--) {
            // 1231 = hashcode for Boolean.TRUE
            int bit = (fieldValues[i].hashCode() == Boolean.TRUE.hashCode() ? 1 : 0) << i;
            hashCode = hashCode | bit;
        }
        return hashCode;
    }

    @Override
    public boolean equals(Object inObj) {
        return this.hashCode() == inObj.hashCode();
        /*try {
            if (inObj instanceof RenewalInsurerDecisionInfoKey) {
                Object[] currentObjFieldValues = getFieldValues(this);
                Object[] inObjFieldValues = getFieldValues(inObj);
                for (int i = 0; i < currentObjFieldValues.length - 1; i++) {
                    if (currentObjFieldValues[i].equals(inObjFieldValues[i])) {
                        continue;
                    }
                    else {
                        return false;
                    }
                }
                return true;
            }
            else {
                return false;
            }
        }
        catch (Throwable tr) {
            System.out.println(tr);
            return false;
        }*/
    }
}
