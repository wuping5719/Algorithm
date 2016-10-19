package interview;

/**
 * @author WuPing
 * @version 2016年8月15日 下午3:28:54
 */

enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}

public class EnumOne {

    public static void main(String[] args) {
	System.out.println(AccountType.FIXED);
    }

}
