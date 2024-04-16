/*                                  Auto-complete feature using Trie
                                    ---------------------------------
                                    
We are given a Trie with a set of strings stored in it.
Now the user types in a prefix of his search query, we need to give him all recommendations to auto-complete 
his query based on the strings stored in the Trie. We assume that the Trie stores past searches by the users.

For example:-
            if the Trie store {“abc”, “abcd”, “aa”, “abbbaba”} and the User types in “ab” 
            then he must be shown {“abc”, “abcd”, “abbbaba”}.
*/

package Tries;

import java.util.ArrayList;
import java.util.List;

class triea{
    triea[]childs;
    int StringNo;
    List<Integer> possibles;
    public triea(){
        childs=new triea[26];
        StringNo=0;
        possibles=new ArrayList<>();
    }
}
public class AutoCompleteFeature {
    public static void insert(triea root,String word,int No){
        triea curr=root;
        for(int i=0;i<word.length();i++){
            int id=word.charAt(i)-'a';
            if(curr.childs[id]==null){
                curr.childs[id]=new triea();
            }
            curr.childs[id].possibles.add(No);
            curr=curr.childs[id];
        }
    }

    public static List<Integer> search(triea root,String word){
        triea curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.childs[idx]==null){
                break;
            }
            else{
                curr=curr.childs[idx];
            }
        }
        return curr.possibles;

    }
    public static void main(String[] args) {
        String[] words={"abcd","abba","abdwh","ab","cdefg"};
        triea root=new triea();
        String[] keys={"ab","a","cd","abd","d"};
        int i=0;
        for(String pre:words){
            insert(root,pre,i);
            i++;
        }
        List<Integer>list=new ArrayList<>();
        for(String find:keys){
            list=search(root,find);
            for(int index:list){
                System.out.print(words[index]+" ");
            }
            System.out.println();
        }

    }
}

/*
OUTPUT:=
            abcd abba abdwh ab 
            abcd abba abdwh ab 
            cdefg 
            abdwh 

*/
