import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;

import java.io.File;

public class dicom4che {

    public static void main(String[] args) {
        String dicomFilePath = "D:\\dicomreader\\content1545.dcm";  

        try (DicomInputStream dis = new DicomInputStream(new File(dicomFilePath))) {
            Attributes attrs = dis.readDataset(-1, -1);

            // Print common tags
            System.out.println("Patient Name: " + attrs.getString(Tag.PatientName));
            System.out.println("Patient ID: " + attrs.getString(Tag.PatientID));
            System.out.println("Patient Birth Date: " + attrs.getString(Tag.PatientBirthDate));
            System.out.println("Patient Sex: " + attrs.getString(Tag.PatientSex));

            System.out.println("Study Instance UID: " + attrs.getString(Tag.StudyInstanceUID));
            System.out.println("Series Instance UID: " + attrs.getString(Tag.SeriesInstanceUID));
            System.out.println("SOP Instance UID: " + attrs.getString(Tag.SOPInstanceUID));

            System.out.println("Modality: " + attrs.getString(Tag.Modality));
            System.out.println("Study Date: " + attrs.getString(Tag.StudyDate));
            System.out.println("Study Time: " + attrs.getString(Tag.StudyTime));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

