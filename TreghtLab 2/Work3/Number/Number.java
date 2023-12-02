package Work3.Number;

import java.io.*;

import Work3.DuplicateModelNameException;
import Work3.NoSuchModelNameException;
import Work3.Car.Car;
import Work3.Motoricle.Motoricle;
import Work3.VehicleUtils.VehicleUtils;
import Work3.Vehicle.Vehicle;

public class Number {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException, IOException, ClassNotFoundException{
        
        Vehicle c = new Car("Pezho", 5);

        System.out.println("\nMarka: "+c.getMake());

        c.setModelName(2, "Fiesta");
        c.setModelPrice("Fiesta",1000);
        c.setModelName(1, "Solyaris");
        c.setModelPrice("Solyaris",1000);
        c.setModelName(3, "Supra");
        c.setModelPrice("Supra",500);
        c.setModelName(0, "Skuline");
        c.setModelPrice("Skuline",4000);
        c.setModelName(4, "Astra");
        c.setModelPrice("Astra",100);

        System.out.println("\nЦена Skuline : "+c.getModelPrice("Skuline"));

        VehicleUtils.printAllModelPrices(c);

        c.addModel("m5",700);

        c.removeModel("Solyaris");

        c.ModifName("Killa", "m5");

        VehicleUtils.printAllModelPrices(c);

        Motoricle m = new Motoricle("BMW", 6);

        System.out.println("\nMarka: "+m.getMake());
        System.out.println("Время последней модификации:"+m.GetLastModif());
        m.setModelName(2, "Granta");
        m.setModelPrice("Granta",1000);
        m.setModelName(1, "Kalina");
        System.out.println("Время последней модификации:"+m.GetLastModif());
        m.setModelPrice("Kalina",3000);
        m.setModelName(3, "Vesta");
        m.setModelPrice("Vesta",500);
        m.setModelName(0, "Honda");
        m.setModelPrice("Honda",4000);
        m.setModelName(4, "Dio");
        m.setModelPrice("Dio",100);
        m.setModelName(5, "Dior");
        m.setModelPrice("Dior",100);
  
        System.out.println("\nЦена Dio : "+m.getModelPrice("Dio"));

        String[] aboba = m.getModelNames();

        System.out.println("\nSpisok modeley: ");
        for(int i = 0; i< aboba.length;i++){
            System.out.println(aboba[i]);
        }

        double[] aboba2 = m.getModelPrices();
        
        System.out.println("\nSpisok cen: ");
        for(int i = 0; i< aboba2.length;i++){
            System.out.println(aboba2[i]);
        }

        m.addModel("x5",700);

        m.removeModel("Vesta");

        aboba = m.getModelNames();

        System.out.println("\nSpisok modeley: ");
        for(int i = 0; i< aboba.length;i++){
            System.out.println(aboba[i]);
        }

        aboba2 = m.getModelPrices();

        System.out.println("\nSpisok cen: ");
        for(int i = 0; i< aboba2.length;i++){
            System.out.println(aboba2[i]);
        }
        
        Vehicle[] vehicleList = new Vehicle[2];

        vehicleList[0] = c;
        vehicleList[1] = m;
        
        System.out.println("Сред стоимость машин моделей: " + VehicleUtils.getAverageModelPrice(vehicleList[0]));
        System.out.println("Сред стоимость мотоциклов моделей: " + VehicleUtils.getAverageModelPrice(vehicleList[1]));

        FileOutputStream baoss1 = new FileOutputStream("1.txt");
        VehicleUtils.outputVehicle(m, baoss1);
        baoss1.close();

        FileInputStream baiss1 = new FileInputStream("1.txt");
        Vehicle tmp = VehicleUtils.inputVehicle(baiss1);
        baiss1.close();

        System.out.println("\nMarka: "+tmp.getMake());
        
        VehicleUtils.printAllModelPrices(tmp);

        FileWriter fr = new FileWriter("2.txt");
        VehicleUtils.writeVehicle(c,fr);
        fr.close();

        FileReader fr2 = new FileReader("2.txt");
        Vehicle tmp2 = VehicleUtils.readVehicle(fr2);
        fr2.close();

        System.out.println("\nMarka: "+tmp2.getMake());
        VehicleUtils.printAllModelPrices(tmp2);

        FileOutputStream temp = new FileOutputStream("3.txt");
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(temp);
        objectOutputStream.writeObject(m);
        objectOutputStream.close();

        FileInputStream temp2 = new FileInputStream("3.txt");
        ObjectInputStream objectInputStream= new ObjectInputStream(temp2);
        Vehicle motoVehicle = (Motoricle)objectInputStream.readObject();
        temp2.close();

        System.out.println("\nMarka: "+motoVehicle.getMake());
        VehicleUtils.printAllModelPrices(motoVehicle);

        Writer writer = new OutputStreamWriter(System.out);
        Reader reader = new InputStreamReader(System.in);

        VehicleUtils.writeVehicle(c, writer);
        Vehicle tmp3 = VehicleUtils.readVehicle(reader);

        System.out.println("\n\nMarka: "+tmp3.getMake());
        VehicleUtils.printAllModelPrices(tmp3);

        System.out.println(c.getClass());

        //System.out, System.in
        //признак класса
    }
}