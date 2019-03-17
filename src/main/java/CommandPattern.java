import java.util.ArrayList;
import java.util.List;

public class CommandPattern {
        public static void main(String[] args) {
               Executor executor = new Executor();
//              executor.executeOperation(new OpenFileOperation(new File("txt")));
               executor.executeOperation(() -> new OpenFileOperation(new File("txt")).execute());


        }
}
class Executor{
        public void executeOperation(FileOperation fileOperation){
                System.out.println("execute operation");
                fileOperation.execute();
        }
}

interface FileOperation{
void execute();
}
class OpenFileOperation implements FileOperation{
private File file;
OpenFileOperation(File file){
        this.file = file;
}

        @Override
        public void execute() {
                System.out.println("execute of open file operation");
                file.open();
        }
}
class SaveFileOperation implements FileOperation{
        private File file;
        SaveFileOperation(File file){
                this.file = file;
        }
        @Override
        public void execute() {
                file.save();
        }
}
class DeleteFileOperation implements FileOperation{
        private File file;
        DeleteFileOperation(File file){
                this.file = file;
        }
        @Override
        public void execute() {
                file.delete();
        }
}
class File{
        String fileName;
        File(String fileName){
                this.fileName = fileName;
        }
        void open(){
                System.out.println("Open " + fileName);
        }
        void save(){
                System.out.println("Save " + fileName);
        }
        void delete(){
                System.out.println("Delete " + fileName);
        }

}
