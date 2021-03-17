package cmet.ac.st20141224.FileIO;

import java.io.IOException;
public interface IFileReader {
    public void read() throws IOException; // Throws read error
    public Object getData(); // returns the data read from the file.
    public void setFilename(String filename); // Sets the filepath for the IO reader classes
    public String getFilename(); // Gets the filepath for the IO reader classes
}
