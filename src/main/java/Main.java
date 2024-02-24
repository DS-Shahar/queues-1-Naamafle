class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
    public static Queue<Integer> cloneQueue(Queue<Integer> q)
    {
        Queue<Integer> newQ = new Queue<Integer>();
        Queue<Integer> tmp = new Queue<Integer>();
        while (!q.isEmpty())
        {
            newQ.insert(q.head());
            tmp.insert(q.remove());
        }
        while (!tmp.isEmpty())
            q.insert(tmp.remove());
        return newQ;
    }
    public static Queue<Character> cloneQueueChar(Queue<Character> q)
    {
        Queue<Character> newQ = new Queue<Character>();
        Queue<Character> tmp = new Queue<Character>();
        while (!q.isEmpty())
        {
            newQ.insert(q.head());
            tmp.insert(q.remove());
        }
        while (!tmp.isEmpty())
            q.insert(tmp.remove());
        return newQ;
    }
    public static Queue<String> cloneQueueString(Queue<String> q)
    {
        Queue<String> newQ = new Queue<String>();
        Queue<String> tmp = new Queue<String>();
        while (!q.isEmpty())
        {
            newQ.insert(q.head());
            tmp.insert(q.remove());
        }
        while (!tmp.isEmpty())
            q.insert(tmp.remove());
        return newQ;
    }
    public static boolean isIn(Queue<Integer> q,int x){
        Queue<Integer> temp = cloneQueue(q);
        while(!temp.isEmpty()){
            if(temp.remove()==x){
                return true;
            }
        }
        return false;
    }
    public static boolean isIn2Times(Queue<Integer> q,int x){
        Queue<Integer> temp = cloneQueue(q);
        int counter=0;
        while(!temp.isEmpty()){
            if(temp.remove()==x){
                counter++;
            }
        }
        return counter>1;
    }
    public static boolean isIn2TimesString(Queue<String> q,String x){
        Queue<String> temp = cloneQueueString(q);
        int counter=0;
        while(!temp.isEmpty()){
            if(temp.remove().equals(x)){
                counter++;
            }
        }
        return counter>1;
    }
    public static boolean isIn2(Queue<Integer> q,int x){
        q.insert(-1);
        while(q.head()!=-1){
            if(q.head()==x){
                q.insert(q.remove());
                return true;
            }
            q.insert(q.remove());
        }
        return false;
    }
    public static Queue<Integer> turnAround(Queue<Integer> q){
        int x;
        if(q.isEmpty()){
            return q;
        }
        x=q.remove();
        q= turnAround(q);
        q.insert(x);
        return q;
    }

    public static boolean isIn2R(Queue<Integer> q,int num,boolean b){
        int x;
        if(q.isEmpty()){
            return b;
        }
        x=q.remove();
        if(x==num){
            b=true;
        }
        b = isIn2R(q,num,b);
        q.insert(x);
        return b;
    }
    public static Queue<Integer> q6(Queue<Character> q){
        Queue<Character> temp = cloneQueueChar(q);
        Queue<Integer> newq=new Queue<Integer>();
        int counter=1;
        char c = temp.remove();
        char tempc;
        while(!temp.isEmpty()){
            tempc=temp.remove();
            if(tempc==c){
                counter++;
            }
            else{
                newq.insert(counter);
                counter=1;
                c=tempc;
            }
        }
        newq.insert(counter);
        return newq;
    }
    public static boolean q7(Queue<String> q){
        Queue<String> temp=cloneQueueString(q);
        while(!temp.isEmpty()){
            if(isIn2TimesString(q,temp.head())){
                return true;
            }
            temp.remove();
        }
        return false;
    }
    public static Queue<Integer> q8(Queue<Integer> q){
        Queue<Integer> temp=cloneQueue(q);
        Queue<Integer> newq=new Queue<Integer>();
        while(!temp.isEmpty()){
            if(!isIn(newq,temp.head())){
                newq.insert(temp.head());
            }
            temp.remove();
        }
        return newq;
    }

    public static Queue<Integer> q9(Queue<Integer> q) {
        Queue<Integer> q1 = new Queue<>();
        Queue<Integer> q2 = new Queue<>();
            while (!q.isEmpty()) {
                int min = q.remove();
                while (!q.isEmpty()) {
                    int current = q.remove();
                    if (current < min) {
                        q1.insert(min);
                        min = current;
                    } else {
                        q1.insert(current);
                    }
                }
                while (!q1.isEmpty()) {
                    q.insert(q1.remove());
                }
                q2.insert(min);
            }
        return q2;
    }

}
