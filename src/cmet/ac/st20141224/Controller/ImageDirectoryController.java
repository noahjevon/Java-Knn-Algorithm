package cmet.ac.st20141224.Controller;

public class ImageDirectoryController {
//    ArrayList<String> imagesDir     = new ArrayList<>();
//    ArrayList<String> imagesPathDir = new ArrayList<>(); // Array to store image paths
//    String imagesStringDir          = "";
//
//    Model   model;
//    MainView view;
//
//    JFileChooser fileChooser;  // File chooser to allow selection
//
//    public ImageDirectoryController(Model model, MainView view) {
//        this.model  = model;
//        this.view   = view;
//
//        initController();
//    }
//
//    public void initController() {
//        this.view.btnImageDir.addActionListener((ae) -> selectDirectory());
//    }
//
//    public void selectDirectory() {
//        imagesDir.clear();  // Clearing arrays & string
//        imagesPathDir.clear();
//        imagesStringDir = "";
//
//        this.model.setImagetext(imagesStringDir);  // Resetting labels
//        this.view.jlabImg.setText(this.model.getInputtext());
//
//        // Create a new JFrame container
//        JFrame jfrm = new JFrame("Select Directory");
//
//        // Filechooser to select directory
//        this.fileChooser = new JFileChooser();
//        fileChooser.setMultiSelectionEnabled(true);  // Allow multiple selection
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG file", "png");  // File filter
//        fileChooser.setFileFilter(filter);  // Apply file filter
//        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//        int result = fileChooser.showOpenDialog(jfrm);
//
//        if (result == JFileChooser.APPROVE_OPTION) {
//            File[] selectedFile = fileChooser.getSelectedFiles();
//
//            for (File file : selectedFile) {
//                File folder = new File(file.getAbsolutePath());
//                List<File> files = Arrays.asList(folder.listFiles());
//
//                for (File file2 : files) {
//                    // Loading image
//                    BufferedImage img = null;
//                    try {
//                        img = ImageIO.read(new File(String.valueOf(file2)));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    int image_width = img.getWidth();  // Getting image width and height
//                    int image_height = img.getHeight();
//
//                    if (image_width > 32 && image_height > 32) {  // Checking to see if image is over-sized
//                        JOptionPane.showMessageDialog(jfrm, "Image: " + file2.getName() + " over 32x32 px. Could not load.",
//                                "ERROR", JOptionPane.ERROR_MESSAGE);
//                    }
//                    else {  // Image not over-sized. Adding metadata to arrays & string.
//                        imagesDir.add(file2.getName());
//                        imagesPathDir.add(file.getAbsolutePath());
//                        imagesStringDir += file2.getName() + " ";
//                    }
//                }
//
//                if (imagesDir.size() > 3) {
//                    this.model.setImagetext(imagesStringDir);  // Updating labels
//                    this.view.jlabImgDir.setText("Images Selected: Lots!");
//                }
//                else {
//                    this.model.setImagetext(imagesStringDir);  // Updating labels
//                    this.view.jlabImgDir.setText(this.model.getInputtext());
//                }
//            }
//        }
//    }
}
