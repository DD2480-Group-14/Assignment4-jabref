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

public class BookCoverFetcherTest {

    /**
     * Test for requirement RE03
     *
     * Asserts that the system does not try to download
     * a book cover again if timeSincePrevious returns
     * a time in hours < 24
     */
    @Test
    public void checkBookCoverFetchCooldown(@TempDir Path path) {
        ExternalApplicationsPreferences preferences = mock(ExternalApplicationsPreferences.class);
        BookCoverFetcher fetcher = spy(new BookCoverFetcher(preferences));

        ISBN isbn = new ISBN("123");

        doReturn(Optional.empty()).when(fetcher).findExistingImage(any(), any());
        doNothing().when(fetcher).downloadCoverImage(any(), any(), any());
        doReturn(Optional.of(Duration.ofHours(25))).doReturn(Optional.of(Duration.ofHours(1))).when(fetcher).timeSincePreviousAttempt(any(), any());
        fetcher.downloadCoverForISBN(isbn, path);
        fetcher.downloadCoverForISBN(isbn, path);

        verify(fetcher, times(1)).downloadCoverImage(any(), any(), any());
    }
}
