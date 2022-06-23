package book;

public class Heap2 {
    int length;
    int orangalOil;


    public int finishRoad(int length, int P, int[] stations, int[] add){
        int result = 0;
        if(stations.length<=0 && P<length ){
            return -1;
        }
        if (stations.length != add.length){
            return -1;
        }
        for(int i = 0;i<stations.length;i++){
            int loc = 0;
            loc += stations[i];
            if(P < loc){
                return -1;
            }else{
                result+=1;
            }
            P +=add[i];
        }
        return result;
    }

}
