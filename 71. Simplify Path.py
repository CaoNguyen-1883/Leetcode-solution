

class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        for dir in path.split("/"):
            if dir in ('', '.'):
                continue
            if dir == '..':
                if stack:
                    stack.pop()
            else:
                stack.append(dir)
        
        return "/" + "/".join(stack)
            