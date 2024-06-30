package org.behavioral.client;

import org.behavioral.visitor.fileoperation.elements.Directory;
import org.behavioral.visitor.fileoperation.elements.File;
import org.behavioral.visitor.fileoperation.elements.FileSystem;
import org.behavioral.visitor.fileoperation.elements.FileSystemNode;
import org.behavioral.visitor.fileoperation.visitors.ReportGeneratorVisitor;
import org.behavioral.visitor.fileoperation.visitors.SearchVisitor;
import org.behavioral.visitor.fileoperation.visitors.SizeCalculatorVisitor;

public class FileSystemClient
{
    public static void main(String... args)
    {
        FileSystem fileSystem = new FileSystem();

        Directory root = new Directory("root");
        Directory home = new Directory("home");
        Directory user = new Directory("user");

        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.bin", 200);
        File file3 = new File("file3.txt", 300);

        user.addNode(file1);
        user.addNode(file2);
        home.addNode(user);
        root.addNode(home);
        root.addNode(file3);

        fileSystem.addNode(root);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        SearchVisitor searchVisitor = new SearchVisitor("file");
        ReportGeneratorVisitor reportVisitor = new ReportGeneratorVisitor();

        fileSystem.accept(sizeVisitor);
        fileSystem.accept(searchVisitor);
        fileSystem.accept(reportVisitor);

        System.out.println("Total Size: " + sizeVisitor.getTotalSize() + " bytes");

        System.out.println("Search Results:");
        for (FileSystemNode node : searchVisitor.getFoundNodes())
        {
            switch (node)
            {
                case File file -> System.out.println("File: " + file.getName());
                case Directory dir -> System.out.println("Directory: " + dir.getName());
                default -> System.out.println("Default case : " + node.getName());

            }
        }
        System.out.println("\nFile System Report:\n" + reportVisitor.getReport());
    }
}
