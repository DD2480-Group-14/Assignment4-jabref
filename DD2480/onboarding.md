# Onboarding Documentation


## Project
JabRef — open-source reference manager  
Repository: https://github.com/DD2480-Group-14/Assignment4-jabref  
Issue being resolved: #4 (Download book cover when entry editor is showing the cover)


## Prerequisites
- IntelliJ IDEA (https://www.jetbrains.com/idea/)


## Assessment of Onboarding Documentation

The official JabRef contribution guide is at: https://devdocs.jabref.org


## How to set up

### 1. Fork & Clone
- git clone https://github.com/DD2480-Group-14/Assignment4-jabref.git
- cd Assignment4-jabref

### 2. Open IntelliJ IDEA
- Click "Open" and select the `build.gradle` file in the root folder and choose **"Open as Project"**

### 3. Run JabRef
- Open the **Gradle Tool Window** (View → Tool Windows → Gradle)
- Navigate to: `jabgui → Tasks → application → run`
- Select **run**

### 4. Run Tests
- In the terminal: ./gradlew test


## How good is the onboarding document

**Onboarding experience**
The project could be built by cloning the repo and following the instructions in the main project's README.md. The required tools to build the project is JabRef, Java 25 or later, and gradle 9.1 or later. However, gradle was not necessary to install since you could build using ./gradlew test.

The build sometimes conclude with errors in the tests, and several tests are ignored or skipped. Otherwise, building the project with ./gradlew build -x test succeeds.

One of the test, KeyBindingViewModelTest.verifyStoreSettingsWritesChanges(), had AssertionFailedError when project was run. But it has no relationship with BookCoverFetcher or PreviewViewer.

**What was missing or unclear:**
- No mention of minimum RAM requirements
- The JDK version requirement was not explicitly stated from the README
---

## Did you continue with the previous project or choose a new one?
No. This is a different project as we struggled to compile and run the test cases. 