import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.TagFromName;

public class dicomreader {

    public static AttributeList list = new AttributeList();

    public static void main(String[] args) {
        String dicomFile = "D:\\dicomreader\\dicom.dcm";
        try {
            readDicomFile(dicomFile); 
            System.out.println("Study Instance UID : " + tag(TagFromName.StudyInstanceUID));
            System.out.println("Series Instance UID : " + tag(TagFromName.SeriesInstanceUID));
            System.out.println("SOP Instance UID : " + tag(TagFromName.SOPInstanceUID));

            System.out.println("Patient Name : " + tag(TagFromName.PatientName));
            System.out.println("Patient ID : " + tag(TagFromName.PatientID));
            System.out.println("Patient Birth Date : " + tag(TagFromName.PatientBirthDate));
            System.out.println("Patient Sex : " + tag(TagFromName.PatientSex));

            System.out.println("Modality : " + tag(TagFromName.Modality));
            System.out.println("Study Date : " + tag(TagFromName.StudyDate));
            System.out.println("Study Time : " + tag(TagFromName.StudyTime));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readDicomFile(String dicomFilePath) throws Exception {
        list.read(dicomFilePath);
    }

    public static String tag(AttributeTag attrTag) {
        return Attribute.getDelimitedStringValuesOrEmptyString(list, attrTag);
    }
}
