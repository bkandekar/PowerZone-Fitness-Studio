/* POWERZONE FITNESS STUDIO BANER PUNE - MAIN JAVASCRIPT ENGINE */

// DATA MODELS
const WHATSAPP_PHONE = "919876543210";

const STORIES_DATA = [
    { id: "s1", title: "Member PR 180kg", tag: "HEAVY LIFT", category: "Strength", highlight: "Rohan hit 180kg raw deadlift on Baner floor!", details: "Shattered his personal best after 12 weeks of structured strength coaching under Sameer sir." },
    { id: "s2", title: "10 AM Ladies Batch", tag: "LADIES BATCH", category: "Ladies Special", highlight: "High-energy Zumba & Core circuit at 10 AM", details: "Full house at 10 AM batch! Fun workouts, supportive female trainers, and high energy beats." },
    { id: "s3", title: "Eucalyptus Steam", tag: "RECOVERY", category: "Facilities", highlight: "Post-leg day steam room relaxation in Sai Complex", details: "Hygienic eucalyptus-infused steam session in Sai Complex to accelerate muscle recovery." },
    { id: "s4", title: "InBody Scan Result", tag: "RESULTS", category: "Assessment", highlight: "Lost 4.2% body fat in 30 days", details: "Ananya completed her 30-day re-assessment scan showing pure muscle gain and fat loss." },
    { id: "s5", title: "Morning HIIT Circuit", tag: "6:30 AM", category: "Cardio", highlight: "Endurance & Agility kettlebell drills", details: "Sweat-inducing kettlebell and battlerope workout to kickstart your Baner workday." }
];

const REVIEWS_DATA = [
    { name: "Aditya Deshmukh", rating: 5, badge: "Google Verified", comment: "Best gym in Baner! Sameer sir's personal guidance and heavy weight floor are unmatched. Highly recommended." },
    { name: "Pooja Kulkarni", rating: 5, badge: "Ladies Batch Member", comment: "The 10 AM ladies batch is super comfortable, clean and female-trainer lead. Lost 6kg in 2 months!" },
    { name: "Rahul Verma", rating: 5, badge: "Transformation Member", comment: "State of the art machines, clean eucalyptus steam bath, and genuine trainers who don't force unnecessary supplements." },
    { name: "Snehal Patil", rating: 5, badge: "Google Verified", comment: "Friendly atmosphere, great equipment in Sai Complex. Best value for money gym membership in Baner Pune." }
];

const TIMETABLE_DATA = [
    { time: "06:00 AM - 07:30 AM", title: "Early Bird Heavy Strength", coach: "Sameer Sir", tag: "Mon-Sat", desc: "Compound lifts, squats, bench press & deadlift form guidance." },
    { time: "07:30 AM - 09:00 AM", title: "Fat Loss HIIT & Cardio Shred", coach: "Sneha", tag: "Mon-Sat", desc: "High intensity Tabata circuits, battle ropes & kettlebells." },
    { time: "10:00 AM - 11:30 AM", title: "Exclusive Ladies Fitness & Zumba", coach: "Priya", tag: "Ladies Batch", desc: "Private women-only batch focusing on glutes, core & dance cardio." },
    { time: "05:00 PM - 06:30 PM", title: "Evening Athletic Strength", coach: "Rahul", tag: "Evening Batch", desc: "Hypertrophy body split workouts for muscle building." },
    { time: "07:00 PM - 08:30 PM", title: "Core & Functional Circuit", coach: "Sneha", tag: "Evening Batch", desc: "Agility ladder, abdominal shred, and cardiovascular conditioning." },
    { time: "07:00 AM - 11:00 AM", title: "Sunday Open Gym & Recovery", coach: "Floor Team", tag: "Sunday", desc: "Steam bath, mobility mobility drills, and free workout sessions." }
];

const TRAINERS_DATA = [
    { name: "Sameer Coach", role: "Head Coach & Founder", exp: "12+ Yrs Exp", spec: "Bodybuilding, Heavy Compound Power Lifts, Transformation Specialist" },
    { name: "Priya Trainer", role: "Ladies Fitness & Pilates Lead", exp: "7+ Yrs Exp", spec: "Female Body Toning, Posture Correction, Post-Pregnancy Fitness" },
    { name: "Rahul Coach", role: "Powerlifting Coach", exp: "8+ Yrs Exp", spec: "Max Strength, Hypertrophy Splits, Athletic Conditioning" },
    { name: "Sneha Specialist", role: "Zumba & Functional Instructor", exp: "5+ Yrs Exp", spec: "Calorie Shred HIIT, Tabata, Group Energy Workouts" }
];

const TRANSFORMATIONS_DATA = [
    { name: "Rohan M.", result: "Lost 14 kg Fat & Gained Muscle", time: "in 12 Weeks", desc: "Targeted weight training paired with a high-protein Indian diet chart." },
    { name: "Ananya K.", result: "Body Recomp & Toned Glutes/Core", time: "in 8 Weeks", desc: "Attended the 10 AM Ladies Batch consistently with female coach guidance." },
    { name: "Vikram S.", result: "Gained 6 kg Lean Muscle Mass", time: "in 16 Weeks", desc: "Heavy PPL split workout chart and clean surplus meal plan." }
];

const WORKOUT_SPLITS_DATA = [
    { name: "Push / Pull / Legs (PPL)", days: "6 Days / Wk", goal: "Hypertrophy & Strength", focus: "Chest, Back, Legs & Arms", exercises: ["Incline Dumbbell Press (4x10)", "Barbell Back Squat (4x8)", "Lat Pulldowns (4x12)", "Overhead Shoulder Press (3x10)"] },
    { name: "Ladies Tone & Functional Circuit", days: "4-5 Days / Wk", goal: "Fat Loss & Core Strength", focus: "Glutes, Abs, Legs & Posture", exercises: ["Goblet Squats & Glute Bridges (4x15)", "Dumbbell Rows & Lat Raises (3x12)", "Plank & Mountain Climbers (4x45s)", "Zumba Cardio Burn (30 min)"] },
    { name: "Power Bodybuilding Split", days: "5 Days / Wk", goal: "Max Mass & Power", focus: "Full Body Strength", exercises: ["Conventional Heavy Deadlift (5x5)", "Barbell Bench Press (5x5)", "Weighted Dips & Pullups (4x8)", "Barbell Shrugs (4x12)"] }
];

const AMENITIES_DATA = [
    { title: "Heavy Hammer Strength Floor", badge: "4,000 SQ.FT", desc: "Olympic bench press stations, squat cages, dumbbells up to 50 kg, and rubberized anti-slip flooring." },
    { title: "Exclusive Ladies Studio", badge: "10 AM - 12 PM", desc: "Private studio setup with female certified trainers for comfortable workouts." },
    { title: "Eucalyptus Steam & Lockers", badge: "RECOVERY", desc: "Hot steam bath to relax muscles, hygienic private changing cubicles, and key-secured lockers." },
    { title: "InBody Composition Analyzer", badge: "PRECISION", desc: "Medical-grade bio-impedance scanner tracking exact visceral fat and skeletal muscle mass." }
];

const FAQS_DATA = [
    { q: "What are the gym operating hours at Baner?", a: "PowerZone Baner is open Monday to Saturday from 6:00 AM to 10:00 PM continuously. On Sundays, open gym hours are 7:00 AM to 12:00 PM." },
    { q: "Is there a dedicated Ladies Batch?", a: "Yes! We run an exclusive Ladies Batch every morning from 10:00 AM to 12:00 PM with female trainers, private studio comfort, and specialized Zumba/Pilates routines." },
    { q: "Where in Baner is PowerZone located?", a: "We are located on the 2nd Floor, Sai Complex, Above Hotel Rajdhani, Main Baner Road, Baner, Pune - 411045." },
    { q: "Do you provide custom diet and workout charts?", a: "Yes, every member receives a customized Indian meal chart (Veg/Non-Veg) and a physical printed workout chart tailored to their fitness goal." }
];

// STATE VARIABLES
let isAnnualBilling = false;
let selectedGender = "Male";
let selectedGoal = "Fat Loss";
let selectedCategoryPrice = 2500;
let selectedCategoryName = "General Gym Floor Pass";
let selectedDurationMonths = 1;
let selectedAddonsTotal = 0;
let selectedAddonNames = [];

// DOM INITIALIZATION
document.addEventListener("DOMContentLoaded", () => {
    renderStories();
    renderReviews();
    renderTimetable("Mon-Sat");
    renderTrainers();
    renderTransformations();
    renderCalculatorOptions();
    renderSplits();
    renderAmenities();
    renderFaqs();
    calculateMacros();
});

// SCROLL TO SECTION
function scrollToSection(id) {
    const el = document.getElementById(id);
    if (el) el.scrollIntoView({ behavior: 'smooth' });
}

// RENDER FUNCTIONS
function renderStories() {
    const container = document.getElementById("storiesRow");
    if (!container) return;
    container.innerHTML = STORIES_DATA.map(story => `
        <div class="story-bubble" onclick="openStoryModal('${story.id}')">
            <div class="story-ring">
                <div class="story-inner">
                    <i class="fa-solid fa-dumbbell"></i>
                    <span class="story-tag">${story.tag}</span>
                </div>
            </div>
            <span class="story-label">${story.title}</span>
        </div>
    `).join("");
}

function renderReviews() {
    const container = document.getElementById("reviewsGrid");
    if (!container) return;
    container.innerHTML = REVIEWS_DATA.map(rev => `
        <div class="review-card">
            <div class="rev-header">
                <div class="rev-stars"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i></div>
                <span class="rev-badge">${rev.badge}</span>
            </div>
            <p class="rev-comment">"${rev.comment}"</p>
            <div class="rev-author">${rev.name}</div>
        </div>
    `).join("");
}

function renderTimetable(filterTag) {
    const container = document.getElementById("timetableGrid");
    if (!container) return;
    
    // Update active tab buttons
    document.querySelectorAll(".timetable-tabs .tab-btn").forEach(btn => {
        if (btn.innerText.includes(filterTag)) btn.classList.add("active");
        else btn.classList.remove("active");
    });

    const filtered = filterTag === "Mon-Sat" 
        ? TIMETABLE_DATA 
        : TIMETABLE_DATA.filter(t => t.tag.toLowerCase().includes(filterTag.toLowerCase()));

    container.innerHTML = filtered.map(t => `
        <div class="time-card">
            <span class="time-badge">${t.time}</span>
            <h3 style="font-size: 15px; font-weight: 800;">${t.title}</h3>
            <p style="font-size: 12px; color: var(--neon-green); font-weight: 700;">Coach: ${t.coach}</p>
            <p style="font-size: 11px; color: var(--text-muted);">${t.desc}</p>
            <button class="btn-primary-neon mt-10" style="padding: 6px 12px; font-size: 11px;" onclick="openBookingModal('Class Inquiry: ${t.title}')">
                Join Batch
            </button>
        </div>
    `).join("");
}

function filterTimetable(tag) {
    renderTimetable(tag);
}

function renderTrainers() {
    const container = document.getElementById("trainersGrid");
    if (!container) return;
    container.innerHTML = TRAINERS_DATA.map(tr => `
        <div class="card-item">
            <h3 class="card-title">${tr.name}</h3>
            <div class="card-sub">${tr.role} • ${tr.exp}</div>
            <p style="font-size: 12px; color: var(--text-muted); margin-bottom: 14px;">Spec: ${tr.spec}</p>
            <button class="btn-secondary-outline full-width" onclick="openBookingModal('Personal Training with ${tr.name}')">
                Book Personal Guidance
            </button>
        </div>
    `).join("");
}

function renderTransformations() {
    const container = document.getElementById("transformationsGrid");
    if (!container) return;
    container.innerHTML = TRANSFORMATIONS_DATA.map(tf => `
        <div class="card-item" style="border-color: var(--neon-green);">
            <div class="card-sub">${tf.time}</div>
            <h3 class="card-title">${tf.name}</h3>
            <p style="font-size: 14px; color: var(--neon-green); font-weight: 800; margin-bottom: 8px;">${tf.result}</p>
            <p style="font-size: 12px; color: var(--text-muted); margin-bottom: 14px;">${tf.desc}</p>
            <button class="btn-primary-neon full-width" onclick="openBookingModal('Transformation Challenge Request')">
                Start My Transformation
            </button>
        </div>
    `).join("");
}

// MACRO PLANNER LOGIC
function setGender(g) {
    selectedGender = g;
    document.getElementById("genderMale").classList.toggle("active", g === "Male");
    document.getElementById("genderFemale").classList.toggle("active", g === "Female");
    calculateMacros();
}

function setGoal(goal) {
    selectedGoal = goal;
    document.getElementById("goalFatLoss").classList.toggle("active", goal === "Fat Loss");
    document.getElementById("goalRecomp").classList.toggle("active", goal === "Body Recomp");
    document.getElementById("goalMuscle").classList.toggle("active", goal === "Muscle Gain");
    document.getElementById("targetGoalChip").innerText = "Target: " + goal;
    calculateMacros();
}

function calculateMacros() {
    const weight = parseFloat(document.getElementById("weightInput")?.value) || 70;
    const height = parseFloat(document.getElementById("heightInput")?.value) || 175;
    const age = parseInt(document.getElementById("ageInput")?.value) || 26;

    const heightM = height / 100;
    const bmi = (weight / (heightM * heightM)).toFixed(1);

    document.getElementById("bmiValue").innerText = bmi;

    let bmr = (10 * weight) + (6.25 * height) - (5 * age);
    bmr = selectedGender === "Male" ? bmr + 5 : bmr - 161;
    const tdee = Math.round(bmr * 1.375);

    let targetCal = tdee;
    if (selectedGoal === "Fat Loss") targetCal = Math.round(tdee * 0.82);
    else if (selectedGoal === "Muscle Gain") targetCal = Math.round(tdee * 1.15);

    const protein = Math.round(weight * 1.8);
    const fats = Math.round((targetCal * 0.25) / 9);
    const carbs = Math.max(50, Math.round((targetCal - (protein * 4) - (fats * 9)) / 4));

    document.getElementById("calValue").innerText = targetCal + " kcal";
    document.getElementById("protValue").innerText = protein + "g";
    document.getElementById("carbValue").innerText = carbs + "g";
    document.getElementById("fatsValue").innerText = fats + "g";
}

function sendMacroPlanToWhatsApp() {
    const weight = document.getElementById("weightInput").value;
    const height = document.getElementById("heightInput").value;
    const age = document.getElementById("ageInput").value;
    const bmi = document.getElementById("bmiValue").innerText;
    const cal = document.getElementById("calValue").innerText;
    const prot = document.getElementById("protValue").innerText;

    const text = `Hi Sameer Sir! My Fitness Plan from PowerZone App:
- Gender: ${selectedGender} | Age: ${age}
- Weight: ${weight}kg | Height: ${height}cm (BMI: ${bmi})
- Target Goal: ${selectedGoal}
- Daily Target: ${cal} (${prot} Protein)
Please guide me with training and diet at PowerZone Baner!`;

    window.open(`https://wa.me/${WHATSAPP_PHONE}?text=${encodeURIComponent(text)}`, '_blank');
}

// MEMBERSHIP ESTIMATOR LOGIC
function setAnnualBilling(annual) {
    isAnnualBilling = annual;
    document.getElementById("btnMonthly").classList.toggle("active", !annual);
    document.getElementById("btnAnnual").classList.toggle("active", annual);
    updateFeeSummary();
}

function renderCalculatorOptions() {
    const categories = [
        { name: "General Gym Floor Pass", price: 2500 },
        { name: "Personal Training (Coached)", price: 6500 },
        { name: "10 AM Ladies Special Batch", price: 3000 },
        { name: "Corporate Group Pass", price: 2200 }
    ];

    const catGrid = document.getElementById("categoryGrid");
    if (catGrid) {
        catGrid.innerHTML = categories.map((c, idx) => `
            <div class="select-card ${idx === 0 ? 'selected' : ''}" onclick="selectCategory('${c.name}', ${c.price}, this)">
                <strong style="font-size: 13px; display: block;">${c.name}</strong>
                <span style="font-size: 12px; color: var(--neon-green);">₹${c.price}/mo</span>
            </div>
        `).join("");
    }

    const durations = [1, 3, 6, 12];
    const durGrid = document.getElementById("durationGrid");
    if (durGrid) {
        durGrid.innerHTML = durations.map((d, idx) => `
            <div class="select-card ${idx === 0 ? 'selected' : ''}" onclick="selectDuration(${d}, this)">
                <strong style="font-size: 13px; display: block;">${d} Month${d > 1 ? 's' : ''}</strong>
                <span style="font-size: 10px; color: var(--text-muted);">${d === 12 ? 'Best Value' : 'Standard'}</span>
            </div>
        `).join("");
    }

    const addons = [
        { name: "Eucalyptus Steam Bath Access", price: 500 },
        { name: "InBody Composition Scans", price: 300 },
        { name: "Personal Locker Key", price: 400 }
    ];

    const addGrid = document.getElementById("addonsGrid");
    if (addGrid) {
        addGrid.innerHTML = addons.map(a => `
            <div class="select-card" onclick="toggleAddon('${a.name}', ${a.price}, this)">
                <strong style="font-size: 12px; display: block;">+ ${a.name}</strong>
                <span style="font-size: 11px; color: var(--text-muted);">+₹${a.price}/mo</span>
            </div>
        `).join("");
    }

    updateFeeSummary();
}

function selectCategory(name, price, el) {
    selectedCategoryName = name;
    selectedCategoryPrice = price;
    document.querySelectorAll("#categoryGrid .select-card").forEach(c => c.classList.remove("selected"));
    el.classList.add("selected");
    updateFeeSummary();
}

function selectDuration(m, el) {
    selectedDurationMonths = m;
    document.querySelectorAll("#durationGrid .select-card").forEach(c => c.classList.remove("selected"));
    el.classList.add("selected");
    updateFeeSummary();
}

function toggleAddon(name, price, el) {
    el.classList.toggle("selected");
    if (el.classList.contains("selected")) {
        selectedAddonsTotal += price;
        selectedAddonNames.push(name);
    } else {
        selectedAddonsTotal -= price;
        selectedAddonNames = selectedAddonNames.filter(n => n !== name);
    }
    updateFeeSummary();
}

function updateFeeSummary() {
    let base = (selectedCategoryPrice + selectedAddonsTotal) * selectedDurationMonths;
    if (isAnnualBilling || selectedDurationMonths === 12) {
        base = Math.round(base * 0.65); // 35% discount
    }

    document.getElementById("summaryCategory").innerText = selectedCategoryName;
    document.getElementById("summaryDuration").innerText = selectedDurationMonths + " Month(s)";
    document.getElementById("summaryAddons").innerText = selectedAddonNames.length > 0 ? selectedAddonNames.join(", ") : "None";
    document.getElementById("summaryTotal").innerText = "₹" + base.toLocaleString('en-IN');
}

function sendFeeEstimateWhatsApp() {
    const total = document.getElementById("summaryTotal").innerText;
    const text = `Hi Sameer Sir! I calculated my fee estimate on PowerZone App:
- Plan: ${selectedCategoryName} (${selectedDurationMonths} Months)
- Addons: ${selectedAddonNames.length > 0 ? selectedAddonNames.join(", ") : "None"}
- Total Estimated Fee: ${total}
Please confirm trial/booking at PowerZone Baner!`;

    window.open(`https://wa.me/${WHATSAPP_PHONE}?text=${encodeURIComponent(text)}`, '_blank');
}

// SPLITS & AMENITIES
function renderSplits() {
    const container = document.getElementById("splitsContainer");
    if (!container) return;
    container.innerHTML = WORKOUT_SPLITS_DATA.map(sp => `
        <div class="card-item" style="margin-bottom: 16px;">
            <div style="display: flex; justify-content: space-between; align-items: center;">
                <h3 class="card-title">${sp.name}</h3>
                <span class="res-badge">${sp.days}</span>
            </div>
            <div class="card-sub">${sp.goal} • Target: ${sp.focus}</div>
            <ul style="font-size: 12px; color: var(--text-muted); margin-left: 16px; margin-bottom: 14px;">
                ${sp.exercises.map(ex => `<li>${ex}</li>`).join("")}
            </ul>
            <button class="btn-primary-neon" style="font-size: 11px; padding: 8px 16px;" onclick="openBookingModal('Printed Chart: ${sp.name}')">
                Get Chart at Desk
            </button>
        </div>
    `).join("");
}

function renderAmenities() {
    const container = document.getElementById("amenitiesGrid");
    if (!container) return;
    container.innerHTML = AMENITIES_DATA.map(am => `
        <div class="card-item">
            <span class="res-badge" style="margin-bottom: 8px; display: inline-block;">${am.badge}</span>
            <h3 class="card-title">${am.title}</h3>
            <p style="font-size: 12px; color: var(--text-muted);">${am.desc}</p>
        </div>
    `).join("");
}

function renderFaqs() {
    const container = document.getElementById("faqAccordion");
    if (!container) return;
    container.innerHTML = FAQS_DATA.map(faq => `
        <div class="faq-item" onclick="this.classList.toggle('open')">
            <div class="faq-q"><span>${faq.q}</span> <i class="fa-solid fa-chevron-down"></i></div>
            <div class="faq-a">${faq.a}</div>
        </div>
    `).join("");
}

function shareReferralWhatsApp() {
    const text = "Hey! Join PowerZone Fitness Gym in Baner Pune with me! Get 3-Day Free Pass and 1 Month Bonus: https://powerzonebaner.in";
    window.open(`https://wa.me/?text=${encodeURIComponent(text)}`, '_blank');
}

// MODALS & FLOATING CONTROLS
function toggleWhatsAppPopover() {
    const pop = document.getElementById("whatsappPopover");
    if (pop) pop.classList.toggle("active");
}

function sendQuickWhatsApp(topic) {
    const text = `Hi Sameer Sir! I have an inquiry regarding: ${topic} at PowerZone Baner. Please guide me!`;
    window.open(`https://wa.me/${WHATSAPP_PHONE}?text=${encodeURIComponent(text)}`, '_blank');
}

function openBookingModal(title = '3-Day Free Trial Pass') {
    document.getElementById("modalTitle").innerText = "Book " + title;
    document.getElementById("bookingModal").classList.add("active");
}

function closeBookingModal() {
    document.getElementById("bookingModal").classList.remove("active");
}

function handleBookingSubmit(e) {
    e.preventDefault();
    const name = document.getElementById("custName").value;
    const phone = document.getElementById("custPhone").value;
    const batch = document.getElementById("custBatch").value;
    const title = document.getElementById("modalTitle").innerText;

    const text = `CONFIRMATION PASS REQUEST
- Goal/Pass: ${title}
- Name: ${name}
- Phone: ${phone}
- Preferred Batch: ${batch}
Hi Sameer Sir, please activate my pass for PowerZone Baner!`;

    closeBookingModal();
    window.open(`https://wa.me/${WHATSAPP_PHONE}?text=${encodeURIComponent(text)}`, '_blank');
}

function openStoryModal(storyId) {
    const story = STORIES_DATA.find(s => s.id === storyId);
    if (!story) return;

    document.getElementById("storyAuthor").innerText = "PowerZone Baner";
    document.getElementById("storyMeta").innerText = "Category: " + story.category;
    document.getElementById("storyTagBadge").innerText = story.tag;
    document.getElementById("storyHighlight").innerText = story.highlight;
    document.getElementById("storyDetails").innerText = story.details;

    document.getElementById("storyModal").classList.add("active");
}

function closeStoryModal() {
    document.getElementById("storyModal").classList.remove("active");
}
