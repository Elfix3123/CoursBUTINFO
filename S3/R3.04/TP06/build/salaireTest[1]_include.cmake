if(EXISTS "/home/felix/Documents/Cours/S3/R3.04/TP06/build/salaireTest[1]_tests.cmake")
  include("/home/felix/Documents/Cours/S3/R3.04/TP06/build/salaireTest[1]_tests.cmake")
else()
  add_test(salaireTest_NOT_BUILT salaireTest_NOT_BUILT)
endif()
