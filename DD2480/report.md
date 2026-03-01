# Report for assignment 4

This is a template for your report. You are free to modify it as needed.
It is not required to use markdown for your report either, but the report
has to be delivered in a standard, cross-platform format.

## Project

Name:

URL:

One or two sentences describing it

## Onboarding experience

Did you choose a new project or continue on the previous one?

If you changed the project, how did your experience differ from before?

## Effort spent

For each team member, how much time was spent in

1. plenary discussions/meetings;

2. discussions within parts of the group;

3. reading documentation;

4. configuration and setup;

5. analyzing code/output;

6. writing documentation;

7. writing code;

8. running code?

For setting up tools and libraries (step 4), enumerate all dependencies
you took care of and where you spent your time, if that time exceeds
30 minutes.

## Overview of issue(s) and work done.

Title:

URL:

Summary in one or two sentences

Scope (functionality and code affected).

## Requirements for the new feature or requirements affected by functionality being refactored

Optional (point 3): trace tests to requirements.

## Code changes

### Patch

(copy your changes or the add git command to show them)

git diff ...

Optional (point 4): the patch is clean.

Optional (point 5): considered for acceptance (passes all automated checks).

## Test results
### Before implementation
#### Test report
The initial test execution for the jabgui module was performed using 
`./gradlew :jabgui:test: --info`.

Out of 770 executed tests, 5 tests failed, and 9 tests were skipped.

Identified Failures:
- `KeyBindingsTabModelTest.randomNewKeyKeyBindingInRepository()`
- `PushToTeXworksTest.pushEntries()`
- `GlobalSearchBarTest.recordingSearchQueriesOnFocusLostOnly(FxRobot)`
- `GlobalSearchBarTest.emptyQueryIsNotRecorded(FxRobot)`
- `ThemeManagerTest.liveReloadCssDataUrl()`

The failing tests seem to be unrelated to the book cover download functionality. They are therefore not expected to interfere with the implementation of the new cover retrieval feature.

Full test log is included [here](https://github.com/DD2480-Group-14/Assignment4-jabref/tree/report/DD2480/reports/test-before/test-log.txt).

#### Coverage report
Even though the test execution was limited to the `jabgui` module, the coverage report includes metrics for the entire project.

| Metric | Coverage % | Raw numbers   |
| ------ | ---------- | ------------- |
| Class  | 25,9%      | (609/2350)    |
| Method | 15,7%      | (2675/17000)  |
| Branch | 9,8%       | (3783/38451)  |
| Line   | 14,1%      | (10997/77950) |

Full coverage report in HTML is included [here](https://github.com/DD2480-Group-14/Assignment4-jabref/tree/report/DD2480/coverage-before/index.html).

### After implementation
#### Test report
#### Coverage report

## UML class diagram and its description

### Key changes/classes affected

Optional (point 1): Architectural overview.

Optional (point 2): relation to design pattern(s).

## Overall experience

What are your main take-aways from this project? What did you learn?

How did you grow as a team, using the Essence standard to evaluate yourself?

Optional (point 6): How would you put your work in context with best software engineering practice?

Optional (point 7): Is there something special you want to mention here?
