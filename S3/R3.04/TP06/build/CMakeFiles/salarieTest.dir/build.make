# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.28

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/felix/Documents/Cours/S3/R3.04/TP06

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/felix/Documents/Cours/S3/R3.04/TP06/build

# Include any dependencies generated for this target.
include CMakeFiles/salarieTest.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/salarieTest.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/salarieTest.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/salarieTest.dir/flags.make

CMakeFiles/salarieTest.dir/salarieTest.cpp.o: CMakeFiles/salarieTest.dir/flags.make
CMakeFiles/salarieTest.dir/salarieTest.cpp.o: /home/felix/Documents/Cours/S3/R3.04/TP06/salarieTest.cpp
CMakeFiles/salarieTest.dir/salarieTest.cpp.o: CMakeFiles/salarieTest.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir=/home/felix/Documents/Cours/S3/R3.04/TP06/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/salarieTest.dir/salarieTest.cpp.o"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/salarieTest.dir/salarieTest.cpp.o -MF CMakeFiles/salarieTest.dir/salarieTest.cpp.o.d -o CMakeFiles/salarieTest.dir/salarieTest.cpp.o -c /home/felix/Documents/Cours/S3/R3.04/TP06/salarieTest.cpp

CMakeFiles/salarieTest.dir/salarieTest.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing CXX source to CMakeFiles/salarieTest.dir/salarieTest.cpp.i"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/felix/Documents/Cours/S3/R3.04/TP06/salarieTest.cpp > CMakeFiles/salarieTest.dir/salarieTest.cpp.i

CMakeFiles/salarieTest.dir/salarieTest.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling CXX source to assembly CMakeFiles/salarieTest.dir/salarieTest.cpp.s"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/felix/Documents/Cours/S3/R3.04/TP06/salarieTest.cpp -o CMakeFiles/salarieTest.dir/salarieTest.cpp.s

CMakeFiles/salarieTest.dir/Salarie.cpp.o: CMakeFiles/salarieTest.dir/flags.make
CMakeFiles/salarieTest.dir/Salarie.cpp.o: /home/felix/Documents/Cours/S3/R3.04/TP06/Salarie.cpp
CMakeFiles/salarieTest.dir/Salarie.cpp.o: CMakeFiles/salarieTest.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir=/home/felix/Documents/Cours/S3/R3.04/TP06/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/salarieTest.dir/Salarie.cpp.o"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/salarieTest.dir/Salarie.cpp.o -MF CMakeFiles/salarieTest.dir/Salarie.cpp.o.d -o CMakeFiles/salarieTest.dir/Salarie.cpp.o -c /home/felix/Documents/Cours/S3/R3.04/TP06/Salarie.cpp

CMakeFiles/salarieTest.dir/Salarie.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing CXX source to CMakeFiles/salarieTest.dir/Salarie.cpp.i"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/felix/Documents/Cours/S3/R3.04/TP06/Salarie.cpp > CMakeFiles/salarieTest.dir/Salarie.cpp.i

CMakeFiles/salarieTest.dir/Salarie.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling CXX source to assembly CMakeFiles/salarieTest.dir/Salarie.cpp.s"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/felix/Documents/Cours/S3/R3.04/TP06/Salarie.cpp -o CMakeFiles/salarieTest.dir/Salarie.cpp.s

# Object files for target salarieTest
salarieTest_OBJECTS = \
"CMakeFiles/salarieTest.dir/salarieTest.cpp.o" \
"CMakeFiles/salarieTest.dir/Salarie.cpp.o"

# External object files for target salarieTest
salarieTest_EXTERNAL_OBJECTS =

salarieTest: CMakeFiles/salarieTest.dir/salarieTest.cpp.o
salarieTest: CMakeFiles/salarieTest.dir/Salarie.cpp.o
salarieTest: CMakeFiles/salarieTest.dir/build.make
salarieTest: lib/libgtest_main.a
salarieTest: lib/libgtest.a
salarieTest: CMakeFiles/salarieTest.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --bold --progress-dir=/home/felix/Documents/Cours/S3/R3.04/TP06/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable salarieTest"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/salarieTest.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/salarieTest.dir/build: salarieTest
.PHONY : CMakeFiles/salarieTest.dir/build

CMakeFiles/salarieTest.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/salarieTest.dir/cmake_clean.cmake
.PHONY : CMakeFiles/salarieTest.dir/clean

CMakeFiles/salarieTest.dir/depend:
	cd /home/felix/Documents/Cours/S3/R3.04/TP06/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/felix/Documents/Cours/S3/R3.04/TP06 /home/felix/Documents/Cours/S3/R3.04/TP06 /home/felix/Documents/Cours/S3/R3.04/TP06/build /home/felix/Documents/Cours/S3/R3.04/TP06/build /home/felix/Documents/Cours/S3/R3.04/TP06/build/CMakeFiles/salarieTest.dir/DependInfo.cmake "--color=$(COLOR)"
.PHONY : CMakeFiles/salarieTest.dir/depend
