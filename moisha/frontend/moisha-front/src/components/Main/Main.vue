<template>
  <div class="Main">
    <div class="main-template">
      <h1><font-awesome-icon :icon="faGraduationCap" class="fa-lg"/></h1>
      <h1 class="display-4">MoiSha</h1>
      <h3 class="font-weight-light">~ 모이샤 ~</h3>
    </div>
    <SignIn></SignIn>
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
