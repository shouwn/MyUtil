package teco.ed;

import java.util.Arrays;

public class E1 {

}

class Solution1 {
    public int solution(String skill, String[] skill_trees) {
        String[] skillOrder = skill.split("");
        int ans = skill_trees.length;

        for(String skillTree : skill_trees){
            int order = 0;

            for(String s : skillTree.split("")){
                if(skill.contains(s)
                        && !skillOrder[order++].equals(s)){
                    ans--;
                    break;
                }
            }
        }

        return ans;
    }
}