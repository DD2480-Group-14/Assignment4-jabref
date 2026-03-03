# Report for assignment 4

## Project

**Name:** JabRef

**URL:** https://github.com/JabRef/jabref

JabRef is a free open source reference management tool, specifically used for BibTeX and LaTeX format. It helps users collect, organize and search for bibliographic data. 

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

## Requirements

| ID   | Title                    | Description                                                                                                                                                      |
| ---- | ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| RE01 | Automatic retrieval      | When a book is opened and no local image file exists for that book, the system should trigger an online search and download of the cover.                        |
| RE02 | Availability flagging    | If a book cover is not available for download, the system should create a file with the ISBN of the book and extension .not-available to document unavailabilty. |
| RE03 | 24-hour check constraint | If a previous attempt of downloading a cover has failed, the system should not try another attempt for the same book within 24-hour time window.                 |
| RE04 | Background processing    | The downloading process should be a background activity, and should not interfere with or delay user interface when a book is opened.                            |

## Existing tests analysis

There doesn't seem to be any tests related to the issue. The file `jabgui/src/main/java/org/jabref/gui/importer/BookCoverFetcher.java`, which is used to fetch book covers, is not covered at all by any tests.

We therefore created some tests that should fail before implementing functionality for the requirements. See `jabgui/src/test/java/org/jabref/gui/importer/BookCoverFetcherTest.java` in the main branch.

## Code changes

### Patch

Link to main PR to JabRef: https://github.com/JabRef/jabref/pull/15250

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

![](./uml.drawio.svg)

The diagram shows 8 classes that are involved in the resolved issue. `PreviewViewer` initiates the download process depending on the `GuiPreferences` -> `PreviewPreferences`. If it should attempt download then it uses the `BookCoverFetcher` to do so and starts this as a `BackgroundTask`, as specified in the requirements. `BookCoverFetcher` is where the majority of our changes are located. The (already existing) download logic extracts the `ISBN` from `BibEntry` to identifiy the book and download the cover. Our implementation creates a `CustomExternalFileType` `".not-available"` for missing book covers, we then check the "last modified" timestamp of that file, if it was more than 24 hours, we can attempt to download again.

### Key changes/classes affected

Optional (point 1): Architectural overview.

Optional (point 2): relation to design pattern(s).

## Overall experience

What are your main take-aways from this project? What did you learn?

Optional (point 6): How would you put your work in context with best software engineering practice?

Optional (point 7): Is there something special you want to mention here?

### Progress of the Team

We would argue that we are now in the `performing` stage where we work effectively and efficiently, if we had more time we could probably become even more efficient. We can also see that with this assignment we are moving into the `adjourned` stage since this our final assignment.

### Way of Working

According to the checklist of "Way-of-Working" we assess our team to be in the `In Place` state. The selected practices and tools were being actively used by the whole team, supporting the collaboration, quality and efficiency of our work. We've gotten a deeper understanding of each other's communication styles and work preferences throughout the assignments, which has continuously strengthen our teamwork.

We don't claim to have reached the `Working Well` state since our workflow was consciously adapted to the specific requirements of each assignment.
