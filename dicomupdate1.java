import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.io.DicomInputStream;
import org.dcm4che2.data.VR;
import org.dcm4che2.io.DicomOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class dicomupdate1 {

    public static void main(String[] args) {
        String dicomFilePath = "D:\\dicomreader\\1.2.40.0.13.1.183722267609197533024418606316316477527.dcm";  
        String outputDicomPath = "D:\\dicomreader\\1.2.40.0.13.1.183722267609197533024418606316316477527.dcm";

        try {
            dicomupdate(dicomFilePath, outputDicomPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void dicomupdate(String inputDicomPath, String outputDicomPath) throws Exception {
        File inputfile = new File(inputDicomPath);
        File outputfile = new File(outputDicomPath);
        
        org.dcm4che3.io.DicomInputStream obj = new DicomInputStream(new FileInputStream(inputfile));
        DicomObject dcmObj = obj.readDicomObject();
        obj.close();
        
        dcmObj.putString(Tag.PatientID, VR.LO, "101012345");
        dcmObj.putString(Tag.PatientName, VR.PN, "XYZ");

        org.dcm4che3.io.DicomOutputStream dos = new DicomOutputStream(new File(outputDicomPath));
            dos.writeDicomFile(dcmObj.getFileMetaInformation(),dcmObj);
            dos.close();
        }
    }
}
