package co.example.fitness;

import android.os.Parcel;
import android.os.Parcelable;

public class FitnessMoveClass implements Parcelable {

    // Nedir bu parcelable ve serializable?
    // Bu iki arkadaş data taşımak için kullanılan bir yöntemdir.
    // Bundan sonra referans tiplerimizi rahatlıkla bu yöntemle taşıyabiliriz.

    //bundle icine her sey koyabiliyorduk
    //ama bir sınıfı obje gibi aktarmak istersek parcelable la yaparız

    private String fitnessName;
    private String fitnessPicture;
    private String fitnessDescription;
    private int fitnessCalorie;

    public FitnessMoveClass(String fitnessName, String fitnessPicture, String fitnessDescription, int fitnessCalorie) {
        this.fitnessName = fitnessName;
        this.fitnessPicture = fitnessPicture;
        this.fitnessDescription = fitnessDescription;
        this.fitnessCalorie = fitnessCalorie;
    }

    public String getFitnessName() {
        return fitnessName;
    }

    public String getFitnessPicture() {
        return fitnessPicture;
    }

    public String getFitnessDescription() {
        return fitnessDescription;
    }

    public int getFitnessCalorie() {
        return fitnessCalorie;
    }



    protected FitnessMoveClass(Parcel in) {

        //gelen parcelabla nasıl okunacak

        fitnessName = in.readString();
        fitnessPicture = in.readString();
        fitnessDescription = in.readString();
        fitnessCalorie = in.readInt();
    }

    public static final Creator< FitnessMoveClass > CREATOR = new Creator< FitnessMoveClass >() {
        @Override
        public FitnessMoveClass createFromParcel(Parcel in) {
            return new FitnessMoveClass(in);
        }

        @Override
        public FitnessMoveClass[] newArray(int size) {
            return new FitnessMoveClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        // parcelable ne yazacaz

        dest.writeString(fitnessName);
        dest.writeString(fitnessPicture);
        dest.writeString(fitnessDescription);
        dest.writeInt(fitnessCalorie);


    }

}
