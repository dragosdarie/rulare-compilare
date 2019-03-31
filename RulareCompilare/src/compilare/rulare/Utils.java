package compilare.rulare;

public class Utils {
    public static class FileOutputInfo
    {
        public OutputDetails Output;
        public String FileName;
        public FILETYPE FileType;

        public FileOutputInfo(String fileName, FILETYPE fileType)
        {
            this.FileName = fileName;
            this.FileType = fileType;
        }

        public FileOutputInfo(){}
    }

    public static class OutputDetails
    {
        public StringBuilder Errors;
        public StringBuilder Output;

        public OutputDetails()
        {
            Errors = new StringBuilder();
            Output = new StringBuilder();
        }
    }
}
