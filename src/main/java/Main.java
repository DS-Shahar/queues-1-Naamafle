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
   public static boolean p151_ex1(Queue<Integer> q, int x) {
        Queue<Integer> temp = cloneQueue(q);
        int prev = q.head();
        while (!temp.isEmpty()) {
            if (temp.remove() == x && prev == x) {
                return true;
            }
            prev = temp.head();
            temp.remove();
        }
        return false;
    }

  //ex17
    public static int p151_ex2(Queue<Time> q) {
        Queue<Time> temp = cloneQueueTime(q);
        Time firstTime = temp.remove();
        Time lastTime = firstTime;
        while (!temp.isEmpty()) {
            lastTime = temp.remove();
        }
        int firstInSeconds = firstTime.getHours() * 3600 + firstTime.getMinutes() * 60 + firstTime.getSeconds();
        int lastInSeconds = lastTime.getHours() * 3600 + lastTime.getMinutes() * 60 + lastTime.getSeconds();
        return lastInSeconds - firstInSeconds;
    }

  //ex18
      public static Queue<Ball> fill(String[] a, int n){
        Queue<Ball> q=new Queue<Ball>();
        int r1;
        int r2;
        for(int i=0;i<n;i++) {
            r1 = (int )(Math.random() * a.length);
            r2 = (int )(Math.random() * 2);
            Ball b=new Ball(r1==1,a[r1]);
            q.insert(b);
        }
        return q;
    }
    public static int place(Queue<Ball> q, Ball b) {
        int i=0;
        q.insert(null);
        while(q!=null){
            if(q.head().getColor().equals(b)){
                return i;
            }
            i++;
            q.insert(q.remove());
        }
        return i;
    }

    public static void p152_ex4(){
        int counter=0;
        String[] arr= {"Yellow","Blue","Green","Purple","Red","Gold"};
        Queue<Ball> q=fill(arr,20);
        int place = place(q,new Ball(true,"Gold"));

        System.out.println("enter a guess: ");
        int guess = reader.nextInt();

        while(guess!=place){
            System.out.println("enter a guess: ");
            guess = reader.nextInt();
            counter++;
        }
        System.out.println(counter+" many guesses");

    }

  //ex19
      public static void p152_ex6(Queue<Job> q, int time) {
        q.insert(null);
        while(q.head()!=null) {
            if(q.head().getTime()<time) {
                q.remove();
                time=time-q.head().getTime();
            }
            else {
                q.insert(q.remove());
            }
        }
        q.remove();
    }

  //ex20
      public static Queue<Integer> p153_ex8(Queue<Integer> q1,Queue<Integer> q2){
        Queue<Integer> newq=new Queue<Integer>();
        while(!q1.isEmpty() && q2.isEmpty()){
            if(q1.head()>=q2.head()) {
                newq.insert(q1.remove());
            }
            else{
                newq.insert(q2.remove());
            }
        }
        while(!q1.isEmpty()){
            newq.insert(q1.remove());
        }
        while(!q2.isEmpty()){
            newq.insert(q2.remove());
        }
        return newq;
    }

  //ex21
   public static String p153_ex9(Queue<Deliveryguy> q,int cc){
        String saveId;
        q.insert(null);
        while(cc>q.head().getCc()){
            q.insert(q.remove());
        }
        saveId=q.head().getId();
        q.remove();
        while(q.head()!=null){
            q.insert(q.remove());
        }
        q.remove();
        return saveId;
    }
 

}
