package com.amit_pc.demoapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by amit_pc on 24-09-2017.
 */

public class ConceptModel implements Parcelable {
    String conceptName;

    public ConceptModel(String conceptName){
        this.conceptName = conceptName;
    }

    protected ConceptModel(Parcel in) {
        conceptName = in.readString();
    }

    public static final Creator<ConceptModel> CREATOR = new Creator<ConceptModel>() {
        @Override
        public ConceptModel createFromParcel(Parcel in) {
            return new ConceptModel(in);
        }

        @Override
        public ConceptModel[] newArray(int size) {
            return new ConceptModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(conceptName);
    }

    public String getConceptName() {
        return conceptName;
    }

    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }
}
