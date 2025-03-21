import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String dirs[] = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String dir : dirs){
            if(dir.isEmpty() || dir.equals(".")) continue;
            if(dir.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            } else{
                stack.add(dir);
            }
        }

        return "/" + String.join("/", stack);
    }
}