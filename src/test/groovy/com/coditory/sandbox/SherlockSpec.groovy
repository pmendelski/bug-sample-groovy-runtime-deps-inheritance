package com.coditory.sandbox

import com.coditory.sherlock.ReactiveInMemorySherlock
import com.coditory.sherlock.ReactorDistributedLock
import com.coditory.sherlock.ReactorSherlock
import com.coditory.sherlock.connector.ReleaseResult
import spock.lang.Specification

class SherlockSpec extends Specification {
  def "should work"() {
    given:
      ReactorSherlock sherlock = ReactorSherlock.toReactorSherlock(ReactiveInMemorySherlock.builder().build())
      ReactorDistributedLock lock = sherlock.createLock("lock");
    when:
      ReleaseResult result = lock.acquire()
        .flatMap({ lock.release() })
        .block()
    then:
      result.released == true
  }
}
