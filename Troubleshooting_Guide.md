# Troubleshooting - First-Time Compilation

If compiling with the following command does not produce .class files (especially AppMain.class):

```
javac -d bin src/com/tmmc/assignment/**/*.java
```

This issue usually occurs on **Windows**, because PowerShell and CMD do **not** support recursive wildcards (**).

## Fix for Windows PowerShell:

1. Instead of the above command, run this explicit compilation command:
   ```
   javac -d bin src\com\tmmc\assignment*.java src\com\tmmc\assignment\image*.java src\com\tmmc\assignment\service*.java src\com\tmmc\assignment\util*.java src\com\tmmc\assignment\exception*.java
   ```
   This manually compiles all source directories.

2. Make sure you are in the **project root directory** where 'src' and 'bin' folders exist.

## Fix for Git Bash or macOS/Linux:
If you are using **Git Bash**, **macOS Terminal**, or **Linux**, ensure recursive wildcards are enabled by running:
```
shopt -s globstar
```
Then re-run:
```
javac -d bin src/com/tmmc/assignment/**/*.java
```

## Alternative (works everywhere):
If the issue persists, use this universal fallback method:
```
   find src -name "*.java" > sources.txt
   javac -d bin @sources.txt
```

This method guarantees all Java files are compiled correctly regardless of your shell environment.

After successful compilation, verify that this file exists:

`bin/com/tmmc/assignment/AppMain.class`

If not, recheck directory structure and rerun the appropriate compile command above.
