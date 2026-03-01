package org.jabref.gui.importer;

import org.jabref.gui.importer.BookCoverFetcher;
import java.nio.file.Path;
import org.jabref.model.entry.identifier.ISBN;
import org.junit.jupiter.api.io.TempDir;
import org.jabref.gui.frame.ExternalApplicationsPreferences;
import java.util.Optional;
import java.time.Duration;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import org.jabref.logic.net.URLDownload;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.jabref.logic.importer.FetcherClientException;
import org.jabref.logic.importer.FetcherException;
import org.jabref.logic.importer.FetcherServerException;
import org.jabref.model.http.SimpleHttpResponse;
import java.net.URL;
import java.io.IOException;
import java.nio.file.Files;

public class BookCoverFetcherTest {

    /**
     * Test for requirement RE02
     *
     * Should create a new file with the extension
     * ".not-available" if a book cover is not available.
     * The test mocks a URLDownloader, and makes it throw
     * an appropriate exception when trying to use the method
     * "toFile". This should then cause the expected file to
     * be created.
     */
    @Test
    public void flagTest(@TempDir Path path) throws Exception{
        ExternalApplicationsPreferences preferences = mock(ExternalApplicationsPreferences.class);
        BookCoverFetcher fetcher = spy(new BookCoverFetcher(preferences));
        String name = "testCover";
        String urlString = "https://example.com/thisisabookcoverthatdoesntexist.jpg";

        URLDownload download = mock(URLDownload.class);
        Path destination = path.resolve(name + ".not-available");

        doThrow(new FetcherClientException(mock(URL.class), mock(SimpleHttpResponse.class))).when(download).toFile(any());

        assertFalse(Files.exists(destination));
        fetcher.downloadCoverHelper(download, destination, path, name, urlString);
        assertTrue(Files.exists(destination));
    }
}
