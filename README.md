### Hexlet tests and linter status:
[![Actions Status](https://github.com/darya-strek/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/darya-strek/java-project-78/actions)
[![Java CI](https://github.com/darya-strek/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/darya-strek/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/27d412f5892a67112f5e/maintainability)](https://codeclimate.com/github/darya-strek/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/27d412f5892a67112f5e/test_coverage)](https://codeclimate.com/github/darya-strek/java-project-78/test_coverage)

### Data validator

Data validator is a library for checking the correctness of the entered data: String, Number, Map. The library has the methods to work with data:
- String:
  - _required()_ - checking whether a string is not _null_ or empty,
  - _minLength()_ - checking if a string is more or equals given length,
  - _contains()_ - checking if a string contains a given substring.
- Number:
  - _required()_ - checking whether a number is not _null_,
  - _positive()_ - checking if a number is positive,
  - _range()_ - checking whether a number is in the range.
- Map:
  - _required()_ - checking whether a map is not _null_,
  - _sizeof()_ - checking whether a map is equal to a given size,
  - _shape()_ - allows to describe validation for inserted objects of Map by keys.
