@echo off

rem Get the list of all .java files in the current directory.
set javaFiles=*.java

rem Create a new text file.
echo Creating all_java_files.txt...
echo. > all_java_files.txt

rem Iterate over the list of .java files and copy their contents to the output file.
for %%f in (%javaFiles%) do (
    echo Copying %%f to all_java_files.txt...
    type %%f >> all_java_files.txt
)

echo Done.