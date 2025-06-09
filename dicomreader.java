import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.TagFromName;

public class dicomreader {

    public static AttributeList list = new AttributeList();

    public static void main(String[] args) {
        String dicomFile = "D:\\dicomreader\\dicom.dcm";
        try {
            loadDicomFile(dicomFile);


           System.out.println("Study Instance UID : " + getTagInformation(TagFromName.StudyInstanceUID));
           System.out.println("Series Instance UID : " + getTagInformation(TagFromName.SeriesInstanceUID));
           System.out.println("SOP Instance UID : " + getTagInformation(TagFromName.SOPInstanceUID));
            
           System.out.println("Patient Name : " + getTagInformation(TagFromName.PatientName));
           System.out.println("Patient ID : " + getTagInformation(TagFromName.PatientID));
           System.out.println("Patient Birth Date : " + getTagInformation(TagFromName.PatientBirthDate));
           System.out.println("Patient Sex : " + getTagInformation(TagFromName.PatientSex));
            
           System.out.println("Modality : " + getTagInformation(TagFromName.Modality));
           System.out.println("Study Date : " + getTagInformation(TagFromName.StudyDate));
           System.out.println("Study Time : " + getTagInformation(TagFromName.StudyTime));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadDicomFile(String dicomFilePath) throws Exception {
        list.read(dicomFilePath);
    }

    public static String getTagInformation(AttributeTag attrTag) {
        return Attribute.getDelimitedStringValuesOrEmptyString(list, attrTag);
    }
}
