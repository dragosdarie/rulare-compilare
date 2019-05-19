package compilare.rulare;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class CompileRunC {

    private static final String  FullOutputPath = Paths.get("").toAbsolutePath().toString() + "\\CompiledC\\";
    private static final String  MingwFolderPath = "C:\\MinGW64\\bin\\";

    public Utils.FileOutputInfo CompileCType(String filePath)
    {
        Utils.FileOutputInfo fileInfo = new Utils.FileOutputInfo();

        String[] files = filePath.split("\\\\");
        String fileName = files[files.length - 1].split(".cpp")[0];

        if (filePath.endsWith(".cpp")) {
            fileInfo = new Utils.FileOutputInfo(fileName, FILETYPE.CPLUSPLUS);
            this.compileCPlusPlus(fileInfo, filePath);
        }
        else if (filePath.endsWith(".c")) {
            fileInfo = new Utils.FileOutputInfo(fileName, FILETYPE.C);
            this.compileC(fileInfo, filePath);
        }

        fileInfo.Output.Output = new StringBuilder();
        return fileInfo;
    }

    public String runFile(String fileName, String input)
    {
        String runFileCommand = "cmd /C "+ FullOutputPath + fileName + " " + input;
        Utils.OutputDetails output = RunCommand(runFileCommand);
        System.out.println("RunFile: " +runFileCommand + "\n" + output.Errors + "\n"+ output.Output + "\nDone!");

        return output.Output.toString();
    }

    private void compileC(Utils.FileOutputInfo fileInfo, String filePath) {
        String compileFileCommand = "cmd /C " + MingwFolderPath + "gcc.exe " + filePath + " -o "+ FullOutputPath + fileInfo.FileName;
        Utils.OutputDetails output = RunCommand(compileFileCommand);
        System.out.println("CompileC: " + compileFileCommand + "\n" + output.Errors + "\n" + output.Output);
        fileInfo.Output = output;
    }

    private void compileCPlusPlus(Utils.FileOutputInfo fileInfo, String filePath) {
        String compileFileCommand = "cmd /C "+ MingwFolderPath + "g++.exe " + filePath + " -o "+ FullOutputPath + fileInfo.FileName;
        Utils.OutputDetails output = RunCommand(compileFileCommand);
        System.out.println("CompileCPlusPlus: " + compileFileCommand + "\n" + output.Errors + "\n" + output.Output);
        fileInfo.Output = output;
    }

    private Utils.OutputDetails RunCommand(String runFileCommand) {
        Utils.OutputDetails commandOutput = new Utils.OutputDetails();
        try {
            Process processRun = Runtime.getRuntime().exec(runFileCommand);

            BufferedReader brCompileError = new BufferedReader(new InputStreamReader(processRun.getErrorStream()));
            String errorCompile;
            while ((errorCompile = brCompileError.readLine()) != null) {
                commandOutput.Errors.append(errorCompile).append("\n");
            }

            BufferedReader commandOutputReader = new BufferedReader(new InputStreamReader(processRun.getInputStream()));
            String output;
            while ((output = commandOutputReader.readLine()) != null) {
                commandOutput.Output.append(output).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commandOutput;
    }
}