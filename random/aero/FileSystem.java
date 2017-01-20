public class FileSystem {

}


class Folder 
{ 
	ArrayList<Folder> subFolderList; 
	ArrayList<File> fileList; 


	Folder(File file) 
	{ 
		fileList.add(file); 
	} 
	Folder(Folder folder) 
	{ 
		subFolderList.add(folder); 
	} 
	Folder(Folder folder, File file) 
	{ 
		folder.addFile(file); 
		subFolderList.addFolder(folder); 
	} 

} 

class File 
{ 
String fileName; 
MetaData metadata; 

File(String fileName, MetaData metadata) 
{ 
	this.fileName = fileName; 
	this.metadata = metadata; 
} 


}

