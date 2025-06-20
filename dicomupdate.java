
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.data.VR;
import org.dcm4che2.io.DicomInputStream;
import org.dcm4che2.io.DicomOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class dicomupdate {

    public static void main(String[] args) {
        String dicomFilePath = "D:\\dcm4che2\\1.2.40.0.13.1.183722267609197533024418606316316477527.dcm";  
        String outputDicomPath = "D:\\dcm4che2\\update.dcm";

        try {
            dicomupdate(dicomFilePath, outputDicomPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void dicomupdate(String inputDicomPath, String outputDicomPath) throws Exception {
        File inputfile = new File(inputDicomPath);
        File outputfile = new File(outputDicomPath);

        DicomInputStream dis = new DicomInputStream(new FileInputStream(inputfile));
        DicomObject dcmObj = dis.readDicomObject();
        dis.close();

        dcmObj.putString(Tag.PatientID, VR.LO, "101012345");
        dcmObj.putString(Tag.PatientName, VR.PN, "lmn");

        DicomOutputStream dos = new DicomOutputStream(new FileOutputStream(outputfile));
        dos.writeDicomFile(dcmObj); 
        dos.close();

        System.out.println( outputDicomPath);
    }
}
