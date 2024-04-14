class triee{
    triee[]childs;
    int stringNo;
    int stringlength;
    public triee(){
        childs=new triee[26];
        stringNo=0;
        stringlength=Integer.MAX_VALUE;
    }
}
class Solution {
    public void insert(String word,triee root,int x,int length){
        triee curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.childs[idx]==null){
                curr.childs[idx]=new triee();
                if(length< curr.childs[idx].stringlength){
                    curr.childs[idx].stringNo=x;
                    curr.childs[idx].stringlength=length;
                }
            }
            else{
                if(length< curr.childs[idx].stringlength){
                    curr.childs[idx].stringNo=x;
                    curr.childs[idx].stringlength=length;
                }
            }
            curr=curr.childs[idx];
        }
    }
    public void getLongestCommonPrefix(String word,List<Integer>list,triee root,int minLengthString){
        triee curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.childs[idx]==null){
                break;
            }
            else{
                minLengthString= curr.childs[idx].stringNo;
            }
            curr=curr.childs[idx];
        }
        list.add(minLengthString);
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        triee root=new triee();
        for(int i=0;i< wordsContainer.length;i++){
            StringBuilder sb=new StringBuilder(wordsContainer[i]);
            sb.reverse();
            String str=sb.toString();
            insert(str,root,i,str.length());
        }
        int min=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i< wordsContainer.length;i++){
            if(wordsContainer[i].length()<min){
                min=wordsContainer[i].length();
                idx=i;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(String prefix:wordsQuery){
            StringBuilder s=new StringBuilder(prefix);
            s.reverse();
            String st=s.toString();
            getLongestCommonPrefix(st,list,root,idx);
        }
        int arr[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}
