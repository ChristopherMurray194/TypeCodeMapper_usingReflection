import java.util.HashMap;

public class Application {

    public enum TypeCode {
        RNAUTO_ISREBROKE_ISINCUMBENT,
        RNAUTO_NOTREBROKE_NOINCUMBENT,
        RNRERATE_ISREBROKE_ISINCUMBENT,
        RNRERATE_NOTREBROKE_NOTINCUMBENT,
        NEW_TYPECODE,
        NOT_FOUND
    }

    public static void main(String[] args) {
        // ** MOCK ENTITY **
        RenewalInsurerDecisionInfo decisionInfo = new RenewalInsurerDecisionInfo();
        decisionInfo.IsRebroked = true;
        decisionInfo.IsIncumbent = true;

        RenewalInsurerDecisionInfoKey key = new RenewalInsurerDecisionInfoKey().build(decisionInfo, 1, false);
        HashMap<RenewalInsurerDecisionInfoKey, TypeCode> map = createMap();
        decisionInfo.outcome = map.getOrDefault(key, TypeCode.NOT_FOUND);
        System.out.println("Typecode outcome is: " + decisionInfo.outcome);
    }

    private static HashMap<RenewalInsurerDecisionInfoKey, TypeCode> createMap() {
        RenewalInsurerDecisionInfoKey key1 = new RenewalInsurerDecisionInfoKey();
        key1.IsAuto = true;
        key1.IsRebroked = true;
        key1.IsIncumbent = true;

        RenewalInsurerDecisionInfoKey key2 = new RenewalInsurerDecisionInfoKey();
        key2.IsAuto = true;
        key2.IsRebroked = false;
        key2.IsIncumbent = false;

        RenewalInsurerDecisionInfoKey key3 = new RenewalInsurerDecisionInfoKey();
        key3.IsAuto = false;
        key3.IsRebroked = true;
        key3.IsIncumbent = true;

        RenewalInsurerDecisionInfoKey key4 = new RenewalInsurerDecisionInfoKey();
        key4.IsAuto = false;
        key4.IsRebroked = false;
        key4.IsIncumbent = false;

        RenewalInsurerDecisionInfoKey newKey = new RenewalInsurerDecisionInfoKey();
        newKey.IsAuto = true;
        newKey.IsRebroked = false;
        newKey.IsIncumbent = false;
        newKey.newColumn = true;

        HashMap<RenewalInsurerDecisionInfoKey, TypeCode> map = new HashMap<RenewalInsurerDecisionInfoKey, TypeCode>();
        map.put(key1, TypeCode.RNAUTO_ISREBROKE_ISINCUMBENT);
        map.put(key2, TypeCode.RNAUTO_NOTREBROKE_NOINCUMBENT);
        map.put(key3, TypeCode.RNRERATE_ISREBROKE_ISINCUMBENT);
        map.put(key4, TypeCode.RNRERATE_NOTREBROKE_NOTINCUMBENT);
        map.put(newKey, TypeCode.NEW_TYPECODE);
        return map;
    }
}