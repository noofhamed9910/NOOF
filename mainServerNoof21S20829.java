public class mainServerNoof21S20829
{
    public static void main(String args[])
    {
        ServerNoof21S20829 NoofSE=new ServerNoof21S20829();
                
                Thread NoofTS=new Thread((Runnable) NoofSE);
                NoofTS.start();
    }
}
