package com.coditory.sandbox;

import com.coditory.sherlock.ReactiveInMemorySherlock;
import com.coditory.sherlock.ReactorDistributedLock;
import com.coditory.sherlock.ReactorSherlock;
import com.coditory.sherlock.connector.ReleaseResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SherlockSpec {
  @Test
  void shouldWork() {
    ReactorSherlock sherlock = ReactorSherlock
      .toReactorSherlock(ReactiveInMemorySherlock.builder().build());
    ReactorDistributedLock lock = sherlock.createLock("lock");
    ReleaseResult result = lock.acquire()
      .flatMap(x -> lock.release())
      .block();
    assertTrue(result.isReleased());
  }
}
