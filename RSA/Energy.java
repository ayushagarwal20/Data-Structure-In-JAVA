import java.util.*;
import java.io.*;
import java.security.*;
class Energy{
    double getEnergy(){
        double[] TR={12.5,25,37.5,50};
        ArrayList<Integer> weight = new ArrayList<>();
        ArrayList<Integer> dv=new ArrayList<>();

                weight.add(2500);
                weight.add(4000);
                weight.add(10000);

        double e1=energy_BVT(weight.get(0));
        double e1temp=energy_BVT(weight.get(1));
        double e2=energy_OXC();
        double e2temp=energy_OXC();
        double e3=energy_EDA(weight.get(0));
        double e3temp=energy_EDA(weight.get(1));
        return e1 + e2 + e3;

    }
    double energy_BVT(int a){
        double e=0;
                if(a <= 1200)
                    e = 50;
                else if(a <= 2400)
                    e = 37.5;
                else if(a <= 4800)
                    e = 25;
                else if(a <= 9600)
                    e = 12.5;
        
        return (1.683*e+91.333);
    }
    double energy_OXC(){
        return ((85 * 10) + (100 * 9) + 150);        
    }
    double energy_EDA(int weight){
        return ((weight / 50.0) + 80.0 + 1) * 100.0;
    }
}