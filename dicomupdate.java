import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomOutputStream;
import org.dcm4che3.data.UID;

import java.io.File;
import java.io.IOException;

public class dicomupdate {

    public static void main(String[] args) {
        String dicomFilePath = "D:\\dicomreader\\1.2.40.0.13.1.183722267609197533024418606316316477527.dcm";  
        String outputDicomPath = "D:\\dicomreader\\1.2.40.0.13.1.183722267609197533024418606316316477527.dcm";

        try {
            dicomupdate(dicomFilePath, outputDicomPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dicomupdate(String inputDicomPath, String outputDicomPath) throws IOException {
        File inputfile = new File(inputDicomPath);
        Attributes attrs;
        Attributes meta;

        try (DicomInputStream obj = new DicomInputStream(inputfile)) {
            attrs = obj.readDataset(-1, -1);
            meta = obj.readFileMetaInformation();
        }
        
        attrs.setString(Tag.PatientID, VR.LO, "101012345");
        attrs.setString(Tag.PatientName, VR.PN, "XYZ");

        if (meta == null) {
            meta = attrs.createFileMetaInformation(UID.ImplicitVRLittleEndian);
        }

        try (DicomOutputStream dos = new DicomOutputStream(new File(outputDicomPath))) {
            dos.writeFileMetaInformation(meta);
            dos.writeDataset( meta,attrs);
        }
    }
}
