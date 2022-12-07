
public class main {
	/** Main method */
	public static void main(String[] args) {
        int[] vezir = new int[64]; // satranc tahtamız 8x8=64 olduğu için
        int i=0,x; // i yerleşen vezir sasyısı, x yerleştirilen index
        
        while(i!=8 ){ // içerdeki while döngüsü dizi tamamen dolduğunda kırıldığında yerleşen vezir değerini kontrol eder
            i=0;
            for(int j=0;j<64;j++)//dizinin bütün elemanlarını 0'a eşitliyoruz.
                vezir[j]=0;     // 0 dizinin boş olduğu anlamına geliyor.
           
        while(i!=8){// toplam 8 tane vezir yerleşene kadar devam edecek
            x = getRandom(); // yerleştirmye rastgele bir sıradan başlıyoruz
            if(vezir[x]==0){//dizinin x. indexi boş ise buraya vezir yerleştirebiliriz
            yerlestirme(vezir, x); // yerleştirme işlemiyle beraber dizinin satırını sütununu ve çaprazını 1 e eşitliyoruz.
            i++; // yerleştirilen vezir sayısı
            }
            if(diziFullDolu(vezir)) // eğer dizi tamamen dolu ise sonzuz dögüyü engellemek için döngüyü kırıyoruz
                break;
        }   
        }
        for(int j=7;j>=0;j--){ 
            for(i=j;i<64;i+=8){
            if(vezir[i]==-1)
                System.out.print("|Q");
            else
                    System.out.print("| ");
        }
            System.out.print("|\n");
        }
        }
        // 0<=x<64 arası bir integer üretiyoruz
        public static int getRandom(){
            return (int) (Math.random()*64);
        }
        // vezir yerleştirme işlemi burada gerçekleşiyor.
        public static void yerlestirme(int[] vezir,int x){ //diziyi ve index i alıyoruz
            int sutun = x/8;
            sutun = sutun*8;
            int satir = x%8;
            int capraz_1 = x;
            int capraz_2 = x;
            while(capraz_1%8!=0 && capraz_1>=9){
            
            capraz_1-=9;
            }
           
            while(capraz_2%8!=0 && capraz_2<57){
                
                capraz_2+=7;
            }
            
            for(int i=sutun;i<sutun+8;i++)
                vezir[i]=1;
            for(int i=satir;i<64;i+=8)
                vezir[i]=1;
            for(int i=capraz_1;i%8!=7 && i<64;i+=9)
                vezir[i]=1;
            for(int i=capraz_2;i>=0 && i%8!=7;i-=7)
                vezir[i]=1;
           vezir[x]=-1;
        }
        // dizinin tamamen dolu olup olmadığını kontrol eder.
        public static boolean diziFullDolu(int[] vezir){
            for(int i=0;i<64;i++)
                if(vezir[i]==0)
                    return false;
            return true;
        }
}