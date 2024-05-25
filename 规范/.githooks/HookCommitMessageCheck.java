import java.util.regex.Pattern;  
  
class HookCommitMessageCheck {  
    public static void main(String[] args) {
        String commitMsg = args[0];
        boolean valid = valid(commitMsg);
        //System.out.println("valid=" + valid);
        if (valid) {
            System.exit(0);
        } else {
            System.exit(1);
        }
    }

    static boolean valid(String message) {
        if ("".equals(message.trim())) {
            return false;
        }
        String regex = "^(Add|Upd|Fix)[:：].*?[,，].*$";
        boolean valid = Pattern.matches(regex, message);

        return valid;
    }
}