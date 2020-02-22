<template>
  <div class="Main">
    하이하이~!
  </div>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faGraduationCap } from '@fortawesome/free-solid-svg-icons'
import SignIn from '@/components/SignIn/SignIn'

export default {
  components: {
    FontAwesomeIcon,
    SignIn
  },
  props: {
  },
  name: 'Main',
  data () {
    return {
      faGraduationCap
    }
  }
}
</script>
