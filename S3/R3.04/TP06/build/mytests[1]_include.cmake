if(EXISTS "/home/felix/Documents/Cours/S3/R3.04/TP06/build/mytests[1]_tests.cmake")
  include("/home/felix/Documents/Cours/S3/R3.04/TP06/build/mytests[1]_tests.cmake")
else()
  add_test(mytests_NOT_BUILT mytests_NOT_BUILT)
endif()
