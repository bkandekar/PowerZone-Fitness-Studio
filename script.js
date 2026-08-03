 /* ==========================================================================
   POWERZONE FITNESS STUDIO - SEPARATE JAVASCRIPT (script.js)
   ========================================================================== */

document.addEventListener("DOMContentLoaded", () => {
  // Timetable Data
  const timetableData = {
    "Mon-Wed-Fri": [
      { time: "06:30 AM - 07:30 AM", title: "Sunrise Strength & Hypertrophy", trainer: "Rahul Sharma (ACE Lead)", slots: "4 Seats Left" },
      { time: "08:30 AM - 09:30 AM", title: "CrossFit HIIT & Fat Loss Circuit", trainer: "Vikram Patil", slots: "6 Seats Left" },
      { time: "11:00 AM - 12:00 PM", title: "Exclusive Ladies Fitness & Toning", trainer: "Priya Kulkarni", slots: "3 Seats Left" },
      { time: "06:00 PM - 07:00 PM", title: "Heavy Barbell & Powerlifting Deck", trainer: "Amit Deshmukh", slots: "2 Seats Left" },
      { time: "07:30 PM - 08:30 PM", title: "Zumba Dance Fitness Beat Party", trainer: "Neha Verma", slots: "5 Seats Left" }
    ],
    "Tue-Thu-Sat": [
      { time: "07:00 AM - 08:00 AM", title: "Power Vinyasa Yoga & Core Conditioning", trainer: "Ananya Joshi", slots: "5 Seats Left" },
      { time: "09:00 AM - 10:00 AM", title: "Kettlebell & Functional Mobility", trainer: "Rahul Sharma", slots: "4 Seats Left" },
      { time: "04:00 PM - 05:00 PM", title: "Ladies Exclusive Weight Loss Batch", trainer: "Priya Kulkarni", slots: "2 Seats Left" },
      { time: "07:00 PM - 08:00 PM", title: "Extreme Fat Loss Calisthenics", trainer: "Vikram Patil", slots: "6 Seats Left" }
    ],
    "Sunday": [
      { time: "08:00 AM - 09:30 AM", title: "Sunday Olympic Deadlift & Squat Clinic", trainer: "Master Coach Rahul", slots: "Only 8 Seats" },
      { time: "10:00 AM - 11:30 AM", title: "Sound Bath & Recovery Yoga Session", trainer: "Ananya Joshi", slots: "10 Seats" }
    ]
  };

  // Render Timetable Grid
  const timetableGrid = document.getElementById("timetableGrid");
  const tabButtons = document.querySelectorAll(".tab-btn");

  function renderTimetable(dayCategory) {
    if (!timetableGrid) return;
    timetableGrid.innerHTML = "";
    const slots = timetableData[dayCategory] || [];

    slots.forEach(slot => {
      const card = document.createElement("div");
      card.className = "slot-card";
      card.innerHTML = `
        <div>
          <div class="slot-time">${slot.time}</div>
          <div class="slot-title">${slot.title}</div>
          <div class="slot-trainer">🎙️ Coach: ${slot.trainer} • <span style="color:#CCFF00">${slot.slots}</span></div>
        </div>
        <button type="button" class="btn btn-sm btn-outline btn-reserve-slot" data-slot="${slot.title} (${slot.time})">Reserve Seat on WhatsApp</button>
      `;
      timetableGrid.appendChild(card);
    });

    // Add event listener to reserve buttons
    document.querySelectorAll(".btn-reserve-slot").forEach(btn => {
      btn.addEventListener("click", (e) => {
        const slotInfo = e.target.getAttribute("data-slot");
        openWhatsAppMessage(`Hi PowerZone Baner! I want to reserve a seat for the batch: ${slotInfo}`);
      });
    });
  }

  // Initial render
  renderTimetable("Mon-Wed-Fri");

  // Tab switcher
  tabButtons.forEach(btn => {
    btn.addEventListener("click", () => {
      tabButtons.forEach(b => b.classList.remove("active"));
      btn.classList.add("active");
      const day = btn.getAttribute("data-day");
      renderTimetable(day);
    });
  });

  // Interactive BMI Calculator Logic
  const btnCalculateBmi = document.getElementById("btnCalculateBmi");
  const bmiHeight = document.getElementById("bmiHeight");
  const bmiWeight = document.getElementById("bmiWeight");
  const bmiValue = document.getElementById("bmiValue");
  const bmiStatus = document.getElementById("bmiStatus");
  const proteinTarget = document.getElementById("proteinTarget");
  const btnBmiWhatsApp = document.getElementById("btnBmiWhatsApp");

  if (btnCalculateBmi) {
    btnCalculateBmi.addEventListener("click", () => {
      const h = parseFloat(bmiHeight.value) / 100;
      const w = parseFloat(bmiWeight.value);

      if (h > 0 && w > 0) {
        const bmi = (w / (h * h)).toFixed(1);
        const bmiNum = parseFloat(bmi);
        bmiValue.innerText = bmi;

        let statusText = "Normal Weight";
        if (bmiNum < 18.5) statusText = "Underweight";
        else if (bmiNum >= 25 && bmiNum < 29.9) statusText = "Overweight";
        else if (bmiNum >= 30) statusText = "Obese Range";

        bmiStatus.innerText = statusText;

        const minProtein = Math.round(w * 1.6);
        const maxProtein = Math.round(w * 2.2);
        proteinTarget.innerText = `${minProtein}g - ${maxProtein}g / day`;
      }
    });
  }

  if (btnBmiWhatsApp) {
    btnBmiWhatsApp.addEventListener("click", () => {
      const h = bmiHeight.value;
      const w = bmiWeight.value;
      const bmi = bmiValue.innerText;
      openWhatsAppMessage(`Hi PowerZone Baner! My Height is ${h}cm, Weight is ${w}kg, BMI is ${bmi}. Please share a custom Indian Diet Chart & Training Routine for Baner.`);
    });
  }


  // Pricing Toggle Logic
  const pricingToggle = document.getElementById("pricingToggle");
  const priceQuarterly = document.getElementById("priceQuarterly");
  const priceYearly = document.getElementById("priceYearly");

  if (pricingToggle) {
    pricingToggle.addEventListener("change", () => {
      if (pricingToggle.checked) {
        priceQuarterly.innerHTML = "₹ 5,999 <span>/ 3 Months (Annual Rate)</span>";
        priceYearly.innerHTML = "₹ 14,999 <span>/ 12 Months (Save 35%)</span>";
      } else {
        priceQuarterly.innerHTML = "₹ 6,499 <span>/ 3 Months</span>";
        priceYearly.innerHTML = "₹ 14,999 <span>/ 12 Months</span>";
      }
    });
  }
.faq-icon::before {
  content: '+';
  font-size: 18px;
  color: var(--primary);
}

.faq-item.open .faq-icon::before {
  content: '−';
}

.faq-answer {
  padding: 0 20px 20px 20px;
  color: var(--text-muted);
  font-size: 14px;
  display: none;
}

.faq-item.open .faq-answer {
  display: block;
   }
  // Modal Handles
  const bookingModal = document.getElementById("bookingModal");
  const referralModal = document.getElementById("referralModal");
  const modalClose = document.getElementById("modalClose");
  const refModalClose = document.getElementById("refModalClose");

  const btnHeroTrial = document.getElementById("btnHeroTrial");
  const btnHeroImageTrial = document.getElementById("btnHeroImageTrial");
  const btnBookTrialNav = document.getElementById("btnBookTrialNav");
  const btnReferral = document.getElementById("btnReferral");

  function openModal(modal) {
    if (modal) modal.classList.add("active");
  }

  function closeModal(modal) {
    if (modal) modal.classList.remove("active");
  }

  if (btnHeroTrial) btnHeroTrial.addEventListener("click", () => openModal(bookingModal));
  if (btnHeroImageTrial) btnHeroImageTrial.addEventListener("click", () => openModal(bookingModal));
  if (btnBookTrialNav) btnBookTrialNav.addEventListener("click", () => openModal(bookingModal));
  if (btnReferral) btnReferral.addEventListener("click", () => openModal(referralModal));

  if (modalClose) modalClose.addEventListener("click", () => closeModal(bookingModal));
  if (refModalClose) refModalClose.addEventListener("click", () => closeModal(referralModal));

  // Program Inquiry Buttons
  document.querySelectorAll(".btn-program-inquire").forEach(btn => {
    btn.addEventListener("click", (e) => {
      const programName = e.target.getAttribute("data-program");
      openWhatsAppMessage(`Hi PowerZone Baner! I want to inquire and book a 3-Day Free Trial for the ${programName} program.`);
    });
  });

  // Membership Plan Selection Buttons
  document.querySelectorAll(".btn-select-plan").forEach(btn => {
    btn.addEventListener("click", (e) => {
      const planName = e.target.getAttribute("data-plan");
      openWhatsAppMessage(`Hi PowerZone Baner! I am interested in joining the ${planName} membership plan.`);
    });
  });

  // Booking Form Submit
  const bookingForm = document.getElementById("bookingForm");
  if (bookingForm) {
    bookingForm.addEventListener("submit", (e) => {
      e.preventDefault();
      const name = document.getElementById("memberName").value;
      const phone = document.getElementById("memberPhone").value;
      const locality = document.getElementById("memberLocality").value;

      closeModal(bookingModal);
      openWhatsAppMessage(`Hi PowerZone Baner! My name is ${name} (${phone}) from ${locality}. Please activate my 3-Day Free Trial Pass & send location pin!`);
    });
  }

  // Share Referral Button
  const btnShareReferral = document.getElementById("btnShareReferral");
  if (btnShareReferral) {
    btnShareReferral.addEventListener("click", () => {
      openWhatsAppMessage("🏋️ Hey! Join me at PowerZone Fitness Studio in Baner Pune! Use my code *POWER-VIP-BANER* for a 3-Day FREE Trial Pass + 10% off membership!");
    });
  }

  // WhatsApp Helper Function
  function openWhatsAppMessage(text) {
    const encodedText = encodeURIComponent(text);
    window.open(`https://wa.me/918329931123?text=${encodedText}`, "_blank");
  }

  // Generic Slider Controls (used by Reviews, Programs, and Amenities sections)
  function initSlider(trackId, prevBtnId, nextBtnId) {
    const track = document.getElementById(trackId);
    const prevBtn = document.getElementById(prevBtnId);
    const nextBtn = document.getElementById(nextBtnId);
    if (!track) return;

    function getScrollStep() {
      const firstCard = track.children[0];
      if (!firstCard) return 300;
      const trackStyle = window.getComputedStyle(track);
      const gap = parseInt(trackStyle.columnGap || trackStyle.gap || "20", 10) || 20;
      return firstCard.offsetWidth + gap;
    }

    if (prevBtn) {
      prevBtn.addEventListener("click", () => {
        track.scrollBy({ left: -getScrollStep(), behavior: "smooth" });
      });
    }
    if (nextBtn) {
      nextBtn.addEventListener("click", () => {
        track.scrollBy({ left: getScrollStep(), behavior: "smooth" });
      });
    }
  }

// Generic Slider Controls (Reviews, Programs, Amenities) — Auto + Manual
  function initSlider(trackId, prevBtnId, nextBtnId, autoPlay = false, intervalMs = 3000) {
    const track = document.getElementById(trackId);
    const prevBtn = document.getElementById(prevBtnId);
    const nextBtn = document.getElementById(nextBtnId);
    if (!track) return;

    function getScrollStep() {
      const firstCard = track.children[0];
      if (!firstCard) return 300;
      const style = window.getComputedStyle(track);
      const gap = parseInt(style.columnGap || style.gap || "20", 10) || 20;
      return firstCard.offsetWidth + gap;
    }

    function scrollNext() {
      const maxScroll = track.scrollWidth - track.clientWidth;
      if (track.scrollLeft >= maxScroll - 5) {
        track.scrollTo({ left: 0, behavior: "smooth" });
      } else {
        track.scrollBy({ left: getScrollStep(), behavior: "smooth" });
      }
    }

    function scrollPrev() {
      if (track.scrollLeft <= 5) {
        track.scrollTo({ left: track.scrollWidth, behavior: "smooth" });
      } else {
        track.scrollBy({ left: -getScrollStep(), behavior: "smooth" });
      }
    }

    if (prevBtn) prevBtn.addEventListener("click", scrollPrev);
    if (nextBtn) nextBtn.addEventListener("click", scrollNext);

    if (autoPlay) {
      let timer = setInterval(scrollNext, intervalMs);

      const pause = () => clearInterval(timer);
      const resume = () => {
        clearInterval(timer);
        timer = setInterval(scrollNext, intervalMs);
      };

      track.addEventListener("mouseenter", pause);
      track.addEventListener("mouseleave", resume);
      track.addEventListener("touchstart", pause, { passive: true });
      track.addEventListener("touchend", resume);
    }
  }

  // Auto-play चालू
  initSlider("reviewsTrack", "reviewsPrev", "reviewsNext", true, 3000);
  initSlider("programsTrack", "programsPrev", "programsNext", true, 3500);
  initSlider("amenitiesTrack", "amenitiesPrev", "amenitiesNext", true, 4000);
