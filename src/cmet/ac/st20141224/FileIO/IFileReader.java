package cmet.ac.st20141224.FileIO;

import java.io.IOException;
public interface IFileReader {
    public void read() throws IOException;
    public Object getData();	// returns the data read from the file.
    public void setFilename(String filename);
    public String getFilename();
    public void setLabelName(String labelName);
}
