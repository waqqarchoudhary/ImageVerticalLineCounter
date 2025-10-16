
ImageVerticalLineCounter
------------------------
Author: Waqqar Choudhary

Overview:
This Windows console application counts the number of vertical black lines in a black-and-white JPG image (e.g., created in MS Paint).

Requirements:
- Java 8 or higher
- JPG images created in MS Paint, with black lines (bucket tool) on a white background

Image Properties:
1. Images must be in JPG format.
2. Lines are created using MS Paint. The image background is default white. The lines are coloured using the bucket tool in black.
3. Each line is a continuous straight line from the top to the bottom of the image.

Test Images:
  img_1.jpg  (1 line)   'images/img_1.jpg'
  img_2.jpg  (3 lines)  'images/img_2.jpg'
  img_3.jpg  (1 line)   'images/img_3.jpg'
  img_4.jpg  (7 lines)  'images/img_4.jpg'

Build Instructions:
-------------------
1. Open a terminal/command prompt in the project root directory.
2. Compile the source code to the `bin` directory (keep .class files out of project files):

	javac -d bin src/com/tmmc/assignment/**/*.java

3. Ensure the `bin` directory contains the compiled `.class` files.

Run Instructions:
-----------------
You can run the application in two ways:

**A. Command-line argument (recommended for assignment):**

	java -cp bin com.tmmc.assignment.AppMain <absolute_image_path>

	Example:
	java -cp bin com.tmmc.assignment.AppMain C:\TMMC_interview_assignment\img_1.jpg

	- If the number of arguments is not exactly 1, an error message is shown and the program exits.

**B. Interactive mode:**
	If no argument is provided, the app will prompt you to enter the image path interactively.
	Type the absolute path and press Enter. Type 'Q' to quit.

Output:
-------
The application prints the number of vertical black lines found in the image.

Error Handling:
---------------
- If the image path is invalid or the file does not exist, an error message is shown.
- If the image format is not supported, an error message is shown.
- All exceptions are caught and printed to the console. The application will not crash unexpectedly.

Notes:
------
- Only JPG images are supported.
- The algorithm assumes lines are perfectly vertical and continuous from top to bottom.
- For a detailed explanation of design principles, architecture, and framework choices, please refer to the accompanying Design_Reasoning.txt file.

Contact:
--------
For any issues, contact waqqarchoudhary@gmail.com
