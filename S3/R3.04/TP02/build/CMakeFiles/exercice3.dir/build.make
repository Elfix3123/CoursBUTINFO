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
CMAKE_SOURCE_DIR = /home/felix/Documents/Cours/S3/R3.04/TP02

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/felix/Documents/Cours/S3/R3.04/TP02/build

# Include any dependencies generated for this target.
include CMakeFiles/exercice3.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/exercice3.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/exercice3.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/exercice3.dir/flags.make

CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.o: CMakeFiles/exercice3.dir/flags.make
CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.o: /home/felix/Documents/Cours/S3/R3.04/TP02/exercice3/exercice3.cpp
CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.o: CMakeFiles/exercice3.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir=/home/felix/Documents/Cours/S3/R3.04/TP02/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.o"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.o -MF CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.o.d -o CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.o -c /home/felix/Documents/Cours/S3/R3.04/TP02/exercice3/exercice3.cpp

CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing CXX source to CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.i"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/felix/Documents/Cours/S3/R3.04/TP02/exercice3/exercice3.cpp > CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.i

CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling CXX source to assembly CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.s"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/felix/Documents/Cours/S3/R3.04/TP02/exercice3/exercice3.cpp -o CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.s

CMakeFiles/exercice3.dir/exercice3/Point.cpp.o: CMakeFiles/exercice3.dir/flags.make
CMakeFiles/exercice3.dir/exercice3/Point.cpp.o: /home/felix/Documents/Cours/S3/R3.04/TP02/exercice3/Point.cpp
CMakeFiles/exercice3.dir/exercice3/Point.cpp.o: CMakeFiles/exercice3.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir=/home/felix/Documents/Cours/S3/R3.04/TP02/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/exercice3.dir/exercice3/Point.cpp.o"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/exercice3.dir/exercice3/Point.cpp.o -MF CMakeFiles/exercice3.dir/exercice3/Point.cpp.o.d -o CMakeFiles/exercice3.dir/exercice3/Point.cpp.o -c /home/felix/Documents/Cours/S3/R3.04/TP02/exercice3/Point.cpp

CMakeFiles/exercice3.dir/exercice3/Point.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing CXX source to CMakeFiles/exercice3.dir/exercice3/Point.cpp.i"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/felix/Documents/Cours/S3/R3.04/TP02/exercice3/Point.cpp > CMakeFiles/exercice3.dir/exercice3/Point.cpp.i

CMakeFiles/exercice3.dir/exercice3/Point.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling CXX source to assembly CMakeFiles/exercice3.dir/exercice3/Point.cpp.s"
	/usr/bin/g++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/felix/Documents/Cours/S3/R3.04/TP02/exercice3/Point.cpp -o CMakeFiles/exercice3.dir/exercice3/Point.cpp.s

# Object files for target exercice3
exercice3_OBJECTS = \
"CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.o" \
"CMakeFiles/exercice3.dir/exercice3/Point.cpp.o"

# External object files for target exercice3
exercice3_EXTERNAL_OBJECTS =

exercice3: CMakeFiles/exercice3.dir/exercice3/exercice3.cpp.o
exercice3: CMakeFiles/exercice3.dir/exercice3/Point.cpp.o
exercice3: CMakeFiles/exercice3.dir/build.make
exercice3: CMakeFiles/exercice3.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --bold --progress-dir=/home/felix/Documents/Cours/S3/R3.04/TP02/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable exercice3"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/exercice3.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/exercice3.dir/build: exercice3
.PHONY : CMakeFiles/exercice3.dir/build

CMakeFiles/exercice3.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/exercice3.dir/cmake_clean.cmake
.PHONY : CMakeFiles/exercice3.dir/clean

CMakeFiles/exercice3.dir/depend:
	cd /home/felix/Documents/Cours/S3/R3.04/TP02/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/felix/Documents/Cours/S3/R3.04/TP02 /home/felix/Documents/Cours/S3/R3.04/TP02 /home/felix/Documents/Cours/S3/R3.04/TP02/build /home/felix/Documents/Cours/S3/R3.04/TP02/build /home/felix/Documents/Cours/S3/R3.04/TP02/build/CMakeFiles/exercice3.dir/DependInfo.cmake "--color=$(COLOR)"
.PHONY : CMakeFiles/exercice3.dir/depend
