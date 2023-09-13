### Hexlet tests and linter status:
[![Actions Status](https://github.com/darya-strek/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/darya-strek/java-project-78/actions)
[![Java CI](https://github.com/darya-strek/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/darya-strek/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/27d412f5892a67112f5e/maintainability)](https://codeclimate.com/github/darya-strek/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/27d412f5892a67112f5e/test_coverage)](https://codeclimate.com/github/darya-strek/java-project-78/test_coverage)

### Data validator

This program allows to validate data: String, Number, Map - in accordance with the following conditions:
- All data: checking for _null_ using the method _required()_;
- String:
  - checking for minimum string length using the method _length()_,
  - checking if a string contains a substring using the method _contains()_;
- Number:
  - checking if a number is positive using the method _positive()_,
  - checking whether a number is in the range using the method _range()_;
- Map:
  - checking whether a map is equal to a given size using the method _sizeof()_.
