package com.example.adam.dso.utils;

import com.example.adam.dso.model.Package;
import com.example.adam.dso.model.Type;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<Package> buildPackages() {
        return Arrays.asList(
                new Package(Type.Linux, "Usługi graficzne Xwindow", "l1.txt"),
                new Package(Type.Linux,"Linux ACL", "l2.txt"),
                new Package(Type.Linux,"RAID", "l3.txt"),
                new Package(Type.Linux,"LAMP", "l4.txt"),
                new Package(Type.Linux,"Wielosystemowość", "l5.txt"),
                new Package(Type.Linux,"Linux Kernel", "l6.txt"),
                new Package(Type.Windows,"AD", "w1.txt"),
                new Package(Type.Windows,"GPO", "w2.txt"),
                new Package(Type.Windows,"Instalacja zdalna", "w3.txt"),
                new Package(Type.Windows,"RAID", "w4.txt"),
                new Package(Type.Windows,"PowerShell", "w5.txt"),
                new Package(Type.Windows,"API", "w6.txt"));
    }
}
