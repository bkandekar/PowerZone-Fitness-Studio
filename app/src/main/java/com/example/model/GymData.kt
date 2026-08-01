package com.example.model

data class ProgramItem(
    val id: String,
    val name: String,
    val category: String,
    val description: String,
    val highlights: List<String>,
    val schedule: String,
    val suitableFor: String,
    val iconName: String
)

data class PricingTier(
    val name: String,
    val badge: String,
    val priceMultiplier: Float,
    val description: String,
    val includedFeatures: List<String>
)

data class MembershipCategory(
    val id: String,
    val title: String,
    val subtitle: String,
    val pricingMap: Map<String, Int?> // Key e.g. "1 Month", "3 Months", "6 Months", "12 Months" -> Price in INR or null
)

data class MembershipAddon(
    val id: String,
    val name: String,
    val price: Int,
    val iconName: String
)

data class PainPointSolution(
    val id: Int,
    val frustration: String,
    val solution: String,
    val iconName: String
)

data class Testimonial(
    val id: Int,
    val name: String,
    val locality: String,
    val result: String,
    val review: String,
    val rating: Int = 5
)

data class GalleryItem(
    val id: String,
    val title: String,
    val category: String,
    val description: String,
    val tag: String
)

// PHASE 2 MODELS
data class ClassSlotItem(
    val id: String,
    val day: String,
    val className: String,
    val category: String,
    val timeSlot: String,
    val instructor: String,
    val openSeats: Int,
    val totalSeats: Int = 20,
    val isLadiesOnly: Boolean = false
)

data class TrainerProfile(
    val id: String,
    val name: String,
    val role: String,
    val certifications: String,
    val specialties: List<String>,
    val experience: String,
    val clientsTransformed: String,
    val bio: String
)

data class TransformationStory(
    val id: String,
    val memberName: String,
    val ageAndLocality: String,
    val programUsed: String,
    val duration: String,
    val weightChange: String,
    val bodyFatChange: String,
    val keyResult: String,
    val quote: String,
    val initialWeight: String,
    val finalWeight: String
)

data class ArticleItem(
    val id: String,
    val title: String,
    val category: String,
    val readTime: String,
    val author: String,
    val date: String,
    val summary: String,
    val paragraphs: List<String>
)

data class FaqItem(
    val id: String,
    val category: String,
    val question: String,
    val answer: String
)

data class VideoItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val duration: String,
    val category: String,
    val thumbnailTag: String
)

data class StoryReelItem(
    val id: String,
    val title: String,
    val tag: String,
    val category: String,
    val highlightText: String,
    val details: String,
    val duration: String = "15s",
    val author: String = "PowerZone Baner"
)

data class AmenityItem(
    val id: String,
    val title: String,
    val badge: String,
    val subtitle: String,
    val description: String,
    val highlights: List<String>
)

data class WorkoutSplitItem(
    val id: String,
    val name: String,
    val subtitle: String,
    val recommendedDays: String,
    val targetGoal: String,
    val exercises: List<String>,
    val muscleFocus: String
)

data class NutritionPlanItem(
    val id: String,
    val title: String,
    val goalTag: String,
    val calories: String,
    val protein: String,
    val carbs: String,
    val fats: String,
    val sampleMeals: List<String>,
    val description: String
)

data class GoogleReview(
    val id: String,
    val reviewerName: String,
    val initial: String,
    val timeAgo: String,
    val rating: Int = 5,
    val reviewText: String,
    val verifiedLocality: String
)

object GymConstants {
    const val BUSINESS_NAME = "PowerZone Fitness Studio"
    const val OWNER_NAME = "Sameer Kulkarni"
    const val LOCATION = "Baner, Pune"
    const val FULL_ADDRESS = "Shop No. 4, Ground Floor, Sai Complex, Near Baner Road Signal, Baner, Pune – 411045"
    const val PHONE_CALLING = "9822011223"
    const val PHONE_DISPLAY = "+91 98220 11223"
    const val WHATSAPP_LEAD_ROUTING = "918329931123" // Primary Lead Routing Number
    const val WHATSAPP_CONTACT = "919822011223"     // Contact WhatsApp
    const val EMAIL = "info@powerzonefitness.in"
    const val YEARS_IN_BUSINESS = "5+"
    const val MEMBERS_TRAINED = "1,200+"
    const val TRAINERS_COUNT = "10+"
    const val TRAINER_CERTIFICATION = "ACE & K11 Certified"
    const val SERVICE_AREAS = "Baner, Balewadi, Aundh, Pashan, Pune"
    const val WORKING_HOURS_WEEKDAYS = "Mon–Sat 6:00 AM – 10:00 PM"
    const val WORKING_HOURS_SUNDAY = "Sunday 8:00 AM – 1:00 PM"
    const val LADIES_BATCH_TIMING = "10:00 AM – 12:00 PM (Mon-Sat)"
    const val INSTAGRAM_HANDLE = "instagram.com/powerzonefitness.pune"
    const val FACEBOOK_HANDLE = "facebook.com/powerzonefitness.pune"
    const val CREDIT_LINE = "Website by ebookcharm Web Services"

    val CLASS_TIMETABLE = listOf(
        ClassSlotItem("c1", "Monday", "Power Zumba Beat", "Zumba", "7:00 AM - 8:00 AM", "Deepika Rao (Zumba Licensed)", 3, 20),
        ClassSlotItem("c2", "Monday", "Ladies Fitness Special", "Ladies Batch", "10:00 AM - 11:30 AM", "Priya Deshmukh (K11)", 4, 15, isLadiesOnly = true),
        ClassSlotItem("c3", "Monday", "CrossFit Fat Shred", "CrossFit", "6:30 PM - 7:30 PM", "Rahul Mehta (ACE)", 2, 15),
        ClassSlotItem("c4", "Tuesday", "Hatha Yoga & Core Flow", "Yoga", "7:00 AM - 8:00 AM", "Siddharth Shinde (Yoga Dip.)", 5, 20),
        ClassSlotItem("c5", "Tuesday", "Hypertrophy Chest & Arms", "Strength", "6:00 PM - 7:00 PM", "Sameer Kulkarni (Founder)", 3, 12),
        ClassSlotItem("c6", "Wednesday", "Bollywood Dance Cardio", "Zumba", "7:00 AM - 8:00 AM", "Deepika Rao (Zumba Licensed)", 2, 20),
        ClassSlotItem("c7", "Wednesday", "Metabolic HIIT Blast", "CrossFit", "6:30 PM - 7:30 PM", "Rahul Mehta (ACE)", 4, 15),
        ClassSlotItem("c8", "Thursday", "Power Vinyasa & Breath", "Yoga", "7:00 AM - 8:00 AM", "Siddharth Shinde (Yoga Dip.)", 6, 20),
        ClassSlotItem("c9", "Thursday", "Ladies Strength & Toning", "Ladies Batch", "10:00 AM - 11:30 AM", "Priya Deshmukh (K11)", 3, 15, isLadiesOnly = true),
        ClassSlotItem("c10", "Friday", "Zumba Fiesta Weekend", "Zumba", "6:30 PM - 7:30 PM", "Deepika Rao (Zumba Licensed)", 1, 20),
        ClassSlotItem("c11", "Saturday", "Weekend Strength Challenge", "Strength", "8:00 AM - 9:30 AM", "Sameer Kulkarni (Founder)", 5, 25),
        ClassSlotItem("c12", "Sunday", "Deep Mobility & Recovery Yoga", "Yoga", "9:00 AM - 10:15 AM", "Siddharth Shinde (Yoga Dip.)", 8, 20)
    )

    val TRAINER_PROFILES = listOf(
        TrainerProfile(
            id = "t1",
            name = "Sameer Kulkarni",
            role = "Founder & Head Master Coach",
            certifications = "ACE Certified Master Trainer • CSCS Specialist",
            specialties = listOf("Hypertrophy", "Biomechanics", "Transformation"),
            experience = "12+ Years Exp",
            clientsTransformed = "450+ Clients",
            bio = "Founder of PowerZone Baner. Specialist in progressive overload, postural alignment, and natural bodybuilding."
        ),
        TrainerProfile(
            id = "t2",
            name = "Rahul Mehta",
            role = "Senior Functional & CrossFit Lead",
            certifications = "K11 Master Diploma in Personal Training",
            specialties = listOf("CrossFit HIIT", "Fat Loss", "Athletic Conditioning"),
            experience = "8+ Years Exp",
            clientsTransformed = "320+ Clients",
            bio = "High-energy coach leading high-intensity metabolic conditioning and kettlebell endurance workouts."
        ),
        TrainerProfile(
            id = "t3",
            name = "Priya Deshmukh",
            role = "Ladies Batch & Clinical Nutrition Lead",
            certifications = "K11 Certified Fitness Coach • Sports Nutritionist",
            specialties = listOf("Post-Pregnancy", "Female Toning", "PCOS Diet Plans"),
            experience = "6+ Years Exp",
            clientsTransformed = "280+ Women",
            bio = "Dedicated female trainer managing PowerZone's exclusive 10 AM - 12 PM Ladies Batch with customized fat loss protocols."
        ),
        TrainerProfile(
            id = "t4",
            name = "Deepika Rao",
            role = "Certified Zumba & Dance Fitness Specialist",
            certifications = "ZIN™ Licensed Zumba Instructor • Aerobics Certified",
            specialties = listOf("Calorie Shred", "Dance Fitness", "Rhythm Cardio"),
            experience = "5+ Years Exp",
            clientsTransformed = "500+ Dancers",
            bio = "Brings electrifying Latin and Bollywood beats to Baner mornings, burning up to 600 kcal per session!"
        ),
        TrainerProfile(
            id = "t5",
            name = "Siddharth Shinde",
            role = "Hatha & Vinyasa Yoga Specialist",
            certifications = "Diploma in Yogic Sciences (Kaivalyadhama)",
            specialties = listOf("Flexibility", "Spine Posture Fix", "Pranayama"),
            experience = "7+ Years Exp",
            clientsTransformed = "200+ Yogis",
            bio = "Helping Baner IT professionals recover from desk-job stiffness, back fatigue, and chronic mental stress."
        )
    )

    val TRANSFORMATION_STORIES = listOf(
        TransformationStory(
            id = "tr1",
            memberName = "Rohan Deshmukh",
            ageAndLocality = "31 yrs • Baner Road, Pune",
            programUsed = "90-Day Fat Loss Challenge",
            duration = "12 Weeks",
            weightChange = "-14.2 kg Fat Lost",
            bodyFatChange = "29% → 17% Body Fat",
            keyResult = "Lost 5 Inches off Waist",
            quote = "Sitting at my IT desk all day in Baner had ruined my health. PowerZone's personal coaching and structured macros changed my life!",
            initialWeight = "88 kg",
            finalWeight = "73.8 kg"
        ),
        TransformationStory(
            id = "tr2",
            memberName = "Ananya Sharma",
            ageAndLocality = "28 yrs • Balewadi, Pune",
            programUsed = "Ladies Batch + Zumba Combo",
            duration = "16 Weeks",
            weightChange = "-9.5 kg Fat Lost",
            bodyFatChange = "32% → 21% Body Fat",
            keyResult = "Reversed Lethargy & Toned Core",
            quote = "The 10 AM Ladies Batch was so comfortable and empowering! Priya ma'am guided my meals without eliminating rotis or rice.",
            initialWeight = "69 kg",
            finalWeight = "59.5 kg"
        ),
        TransformationStory(
            id = "tr3",
            memberName = "Vikram Kulkarni",
            ageAndLocality = "25 yrs • Aundh, Pune",
            programUsed = "180-Day Hypertrophy Gain",
            duration = "24 Weeks",
            weightChange = "+7.8 kg Lean Muscle",
            bodyFatChange = "Maintain 13% Fat",
            keyResult = "Added 4 Inches to Chest",
            quote = "I was a classic hardgainer. Sameer sir fixed my bench press form and protein distribution. PowerZone's heavy power racks are top class!",
            initialWeight = "58 kg",
            finalWeight = "65.8 kg"
        ),
        TransformationStory(
            id = "tr4",
            memberName = "Sneha Kulkarni",
            ageAndLocality = "34 yrs • Pashan, Pune",
            programUsed = "Post-Pregnancy Core & Toning",
            duration = "14 Weeks",
            weightChange = "-11.0 kg Weight",
            bodyFatChange = "Diastasis Recti Healed",
            keyResult = "Regained Pre-Baby Stamina",
            quote = "I was terrified of lifting weights post-baby. The coaches took time to check my core stability and rebuilt my confidence safely.",
            initialWeight = "74 kg",
            finalWeight = "63.0 kg"
        )
    )

    val BLOG_ARTICLES = listOf(
        ArticleItem(
            id = "art1",
            title = "Best Gyms in Baner Pune: Why Location, Equipment & Coaching Matter",
            category = "Baner Fitness Guide",
            readTime = "4 min read",
            author = "Sameer Kulkarni (Founder)",
            date = "July 2026",
            summary = "Looking for a gym near Baner Road signal or Sai Complex? Discover the 5 non-negotiable factors when selecting a fitness center in Pune.",
            paragraphs = listOf(
                "Baner and Balewadi have become Pune's prime residential and IT hubs. With thousands of working professionals commuting daily along Baner Road, staying fit can be a challenge amidst long shifts and heavy traffic.",
                "When choosing a gym in Baner, equipment crowding is the #1 complaint. Conventional commercial gyms over-subscribe memberships, leading to 30-minute waits for bench presses or treadmills during 6 PM - 9 PM peak hours.",
                "At PowerZone Fitness Studio in Sai Complex, we solved this by enforcing capped peak memberships and investing in a spacious 4,000 sq.ft layout with multiple power cages and dumbbell racks up to 50kg.",
                "Secondly, certified coaching makes or breaks your safety. Ensure your gym has full-time ACE and K11 certified trainers on the floor to check posture—not just trainers selling high-priced packages.",
                "Visit PowerZone today for a complimentary 3-day trial pass and experience the difference yourself!"
            )
        ),
        ArticleItem(
            id = "art2",
            title = "Fat Loss vs Weight Loss: How Pune IT Professionals Can Drop Inches Safely",
            category = "Nutrition & Fat Loss",
            readTime = "5 min read",
            author = "Priya Deshmukh (Nutrition Lead)",
            date = "June 2026",
            summary = "Learn why starving yourself on extreme fad diets ruins your metabolism and how Indian macro balanced diets lead to long-term fat loss.",
            paragraphs = listOf(
                "Many gym-goers in Baner make the mistake of starving themselves on liquid cleanses or crash keto diets to lose weight rapidly. However, scale weight loss often includes precious muscle tissue and water weight.",
                "True transformation is Fat Loss—preserving your lean muscle while burning visceral subcutaneous fat. This keeps your basal metabolic rate (BMR) high so you don't rebound once the diet ends.",
                "At PowerZone, we build Pune-friendly nutrition plans that integrate everyday foods like bhakri, paneer, dal, and rice into precise macro targets. No extreme starvation required!",
                "Combine balanced protein intake with compound resistance training 4 days a week to ignite fat loss without losing energy for your work day."
            )
        ),
        ArticleItem(
            id = "art3",
            title = "How to Stay Consistent with Gym Workouts Despite Long IT Shift Hours",
            category = "Lifestyle & Habits",
            readTime = "3 min read",
            author = "Rahul Mehta (Senior Coach)",
            date = "May 2026",
            summary = "Working late night shifts or hybrid desk jobs in Hinjewadi/Baner? Here is a practical strategy to maintain 4 workout sessions a week.",
            paragraphs = listOf(
                "Desk jobs lead to rounded shoulders, tight hip flexors, and lower back fatigue. The key to workout consistency isn't 2-hour daily marathons—it's 45 minutes of targeted intent.",
                "Shift your mindset to 4 focused sessions per week (e.g., Upper Body, Lower Body, Functional Conditioning, and Mobility Recovery).",
                "PowerZone's 6:00 AM to 10:00 PM operating hours give you the flexibility to train before your standup calls or right after evening office logoff.",
                "Book a trial pass to test our early morning 6 AM batch or evening 7 PM functional conditioning group sessions."
            )
        )
    )

    val FAQ_ITEMS = listOf(
        FaqItem("faq1", "Trial & Admission", "How does the Free 3-Day Trial Pass work?", "You can book your trial pass online or via WhatsApp. It gives you 3 consecutive days of unlimited access to the gym floor, cardio zone, and group classes with zero registration fee or pushy sales calls."),
        FaqItem("faq2", "Ladies Batch", "What are the details of the Ladies Batch?", "Our dedicated Ladies Batch runs Monday to Saturday from 10:00 AM to 12:00 PM. It is led by female certified trainer Priya Deshmukh and features complete privacy, customized female toning routines, and Zumba sessions."),
        FaqItem("faq3", "Pricing & Renewal", "Are there any hidden admission or locker fees?", "No! All PowerZone membership packages are fully transparent. Standard floor access, general trainer guidance, and day-use lockers are included in all basic packages."),
        FaqItem("faq4", "Facilities & Timings", "What are the exact operating hours in Baner?", "We are open Monday through Saturday from 6:00 AM to 10:00 PM continuously. Sundays are open from 8:00 AM to 1:00 PM for deep mobility and strength recovery."),
        FaqItem("faq5", "Safety & Hygiene", "How often is the gym equipment sanitized?", "The entire 4,000 sq.ft facility, steam rooms, and locker zones undergo deep chemical sanitization twice daily. Disinfectant wipes and hand sanitizers are available across all workout bays."),
        FaqItem("faq6", "Personal Training", "Do I need a Personal Trainer to get results?", "Not necessarily! All general members receive floor assistance from our ACE/K11 certified trainers for form check and equipment guidance. Personal Training is recommended if you want 1-on-1 diet tracking or accelerated goals.")
    )

    val VIDEO_ITEMS = listOf(
        VideoItem("v1", "4,000 Sq.Ft Studio Walkthrough", "Explore Sai Complex, Baner Facility", "1:45 min", "Studio Tour", "4K Gym Tour"),
        VideoItem("v2", "High-Energy Zumba Session", "Morning Zumba Fiesta with Deepika", "1:15 min", "Zumba Highlights", "Dance Fitness"),
        VideoItem("v3", "Rohan's 12-Week Transformation Story", "How Rohan lost 14 kg fat while working IT", "2:30 min", "Member Review", "Success Story"),
        VideoItem("v4", "CrossFit Metabolic Conditioning", "Battle ropes & sled pushes in action", "1:10 min", "CrossFit Drill", "Functional Zone")
    )

    val GOOGLE_REVIEWS = listOf(
        GoogleReview("gr1", "Saurabh Joshi", "S", "2 weeks ago", 5, "Best gym in Baner! Sameer sir is super knowledgeable about muscle biomechanics. Equipment is brand new and clean. Highly recommended!", "Baner, Pune"),
        GoogleReview("gr2", "Neha Kulkarni", "N", "1 month ago", 5, "The 10 AM Ladies Batch is fantastic! Trainer Priya ma'am gives personal attention to everyone. The steam room facility is a huge bonus.", "Balewadi, Pune"),
        GoogleReview("gr3", "Amit Deshmukh", "A", "3 weeks ago", 5, "Spacious 4000 sq.ft floor near Baner Road signal. No waiting for bench presses during evening hours. Very reasonable fees for the quality.", "Aundh, Pune"),
        GoogleReview("gr4", "Pooja Wani", "P", "2 months ago", 5, "Joined the 90-day transformation challenge. Lost 8 kg in 2 months with proper diet plan and Zumba classes. Atmosphere is super motivating!", "Pashan, Pune")
    )

    val PROGRAMS_OFFERED = listOf(
        ProgramItem(
            id = "strength",
            name = "Strength & Free Weight Training",
            category = "Strength",
            description = "Heavy-duty power racks, Olympic barbells, dumbbells up to 50kg, and isolation machines for complete physique sculpting.",
            highlights = listOf("Olympic Barbells & Bumper Plates", "Isolation Machines & Cable Crossovers", "Pro Form Correction by K11 Trainers"),
            schedule = "Mon - Sat: 6:00 AM - 10:00 PM",
            suitableFor = "Hypertrophy, Raw Power & Muscle Building",
            iconName = "fitness_center"
        ),
        ProgramItem(
            id = "crossfit",
            name = "CrossFit-Style Functional Training",
            category = "Group Classes",
            description = "High-intensity metabolic conditioning combining kettlebells, battle ropes, plyo boxes, and slam balls to boost stamina and burn fat.",
            highlights = listOf("Kettlebells, Battle Ropes & Plyo Boxes", "Sled Push & Conditioning Rigs", "Fat Loss & Stamina Explosion"),
            schedule = "Daily Morning & Evening Batches",
            suitableFor = "Fat Loss, Athletic Agility & High Energy",
            iconName = "bolt"
        ),
        ProgramItem(
            id = "zumba",
            name = "Zumba & Dance Fitness",
            category = "Group Classes",
            description = "Energetic cardiovascular dance sessions set to high-tempo Latin and Bollywood beats led by certified dance workout instructors.",
            highlights = listOf("Fun, High-Calorie Burning Beats", "Up to 600 Calories Burned / Hour", "Vibrant Community Vibe"),
            schedule = "Mon, Wed, Fri: 7:00 AM & 6:30 PM",
            suitableFor = "Calorie Burn, Stress Relief & Mobility",
            iconName = "music_note"
        ),
        ProgramItem(
            id = "yoga",
            name = "Yoga & Meditation",
            category = "Group Classes",
            description = "Mindful hatha and vinyasa flow sessions focusing on core stability, hamstring flexibility, breathwork, and deep mental recovery.",
            highlights = listOf("Postural Alignment & Flexibility", "Guided Pranayama & Stress Release", "Injury Rehabilitation"),
            schedule = "Tue, Thu, Sat: 7:00 AM & 8:00 AM",
            suitableFor = "Flexibility, Core Strength & Inner Calm",
            iconName = "self_improvement"
        ),
        ProgramItem(
            id = "pt",
            name = "1-on-1 Personal Training",
            category = "Personal Training",
            description = "Dedicated ACE/K11 certified coach exclusively tracking your posture, progressive overload, biomechanics, and daily caloric intake.",
            highlights = listOf("Customized Workout Protocols", "Daily Nutrition & Macro Tracking", "Accelerated 2x Faster Results"),
            schedule = "Custom Flexible Appointments",
            suitableFor = "Fast-Track Goals, Post-Injury & Specific Targets",
            iconName = "person"
        ),
        ProgramItem(
            id = "diet",
            name = "Diet & Nutrition Consultation",
            category = "Personal Training",
            description = "Tailored, practical Pune-friendly meal plans designed by sports nutritionists. No extreme starving—just real food that works.",
            highlights = listOf("Indian & Global Macro Adjustments", "InBody Composition Analysis", "Weekly Progress Adjustments"),
            schedule = "Included with All Pro/Elite Plans",
            suitableFor = "Sustainable Weight Loss & Lean Gains",
            iconName = "restaurant"
        ),
        ProgramItem(
            id = "transformation",
            name = "90-Day Body Transformation Challenge",
            category = "Transformation",
            description = "Our flagship result-guaranteed program! Includes personal coaching, bi-weekly InBody scans, custom meal plans, and accountability tracking.",
            highlights = listOf("Guaranteed Inches & Fat Reduction", "Dedicated Master Coach Assigned", "Weekly Progress Photo Reviews"),
            schedule = "Dedicated High-Intensity Batches",
            suitableFor = "Dramatic Fat Loss & Muscle Toning",
            iconName = "workspace_premium"
        ),
        ProgramItem(
            id = "muscle_building",
            name = "180-Day Muscle Building Program",
            category = "Transformation",
            description = "Six-month structured hypertrophy protocol designed for skinny hardgainers or athletes looking to add serious lean muscle mass.",
            highlights = listOf("Periodized Hypertrophy Cycles", "High-Protein Diet Structuring", "Strength Benchmarks Tracking"),
            schedule = "Custom Muscle Split Routines",
            suitableFor = "Hardgainers & Aesthetic Bodybuilders",
            iconName = "directions_run"
        )
    )

    val PRICING_CATEGORIES = listOf(
        MembershipCategory(
            id = "gym_floor",
            title = "Gym Floor & Strength",
            subtitle = "Full access to free weights, power racks & cardio machines",
            pricingMap = mapOf(
                "1 Month" to 2200,
                "3 Months" to 6000,
                "6 Months" to 10500,
                "12 Months" to 17000
            )
        ),
        MembershipCategory(
            id = "group_classes",
            title = "Group Classes",
            subtitle = "Access to Zumba, Yoga, CrossFit & Dance Fitness batches",
            pricingMap = mapOf(
                "1 Month" to 2800,
                "3 Months" to 7200,
                "6 Months" to 12500,
                "12 Months" to 20000
            )
        ),
        MembershipCategory(
            id = "personal_training",
            title = "Personal Training (12 Sessions)",
            subtitle = "Dedicated 1-on-1 ACE/K11 certified personal trainer",
            pricingMap = mapOf(
                "1 Month" to 7000,
                "3 Months" to 19000,
                "6 Months" to null,
                "12 Months" to null
            )
        ),
        MembershipCategory(
            id = "transformation_challenge",
            title = "90-Day Transformation Challenge",
            subtitle = "All-inclusive flat transformation program with custom diet & coach",
            pricingMap = mapOf(
                "3 Months" to 22000,
                "1 Month" to null,
                "6 Months" to null,
                "12 Months" to null
            )
        )
    )

    val PRICING_TIERS = listOf(
        PricingTier(
            name = "Basic Tier",
            badge = "Standard",
            priceMultiplier = 1.0f,
            description = "Standard facility access, gym floor entry & floor assistance.",
            includedFeatures = listOf("Full Gym Floor Access", "General Trainer Guidance", "Locker Room Access")
        ),
        PricingTier(
            name = "Pro Tier",
            badge = "Popular",
            priceMultiplier = 1.25f,
            description = "Includes steam pass, reserved locker & monthly diet assessment.",
            includedFeatures = listOf("Full Gym Floor Access", "Steam Room Access Pass", "Reserved Personal Locker", "Monthly Diet Assessment")
        ),
        PricingTier(
            name = "Elite Tier",
            badge = "VIP Power",
            priceMultiplier = 1.50f,
            description = "VIP experience with dedicated trainer assistance, custom diet plan & steam pass.",
            includedFeatures = listOf("Full Gym Floor & Group Access", "Dedicated Trainer Support", "Customized Nutrition Plan", "Unlimited Steam Room Pass", "Priority Body Scan Analysis")
        )
    )

    val SAMPLE_ADDONS = listOf(
        MembershipAddon("addon_pt", "Dedicated Trainer Assistance", 1500, "sports_gymnastics"),
        MembershipAddon("addon_diet", "Custom Diet Plan", 1000, "restaurant_menu"),
        MembershipAddon("addon_steam", "Steam Room Pass", 700, "hot_tub"),
        MembershipAddon("addon_locker", "Reserved Locker", 500, "lock")
    )

    val PAIN_POINTS_SOLUTIONS = listOf(
        PainPointSolution(
            id = 1,
            frustration = "Crowded equipment & endless waiting in peak hours",
            solution = "Capped peak-hour memberships & spacious 4,000 sq.ft floor layout in Baner so you never wait for weights.",
            iconName = "groups"
        ),
        PainPointSolution(
            id = 2,
            frustration = "Uninterested floor trainers who ignore your posture & form",
            solution = "10+ ACE & K11 Certified Trainers actively on the floor correcting form and keeping you injury-free.",
            iconName = "verified_user"
        ),
        PainPointSolution(
            id = 3,
            frustration = "Rigid gym timings that collide with Pune IT shift work",
            solution = "Flexible 6 AM – 10 PM operating hours + dedicated 10 AM – 12 PM Ladies Batch for total comfort.",
            iconName = "schedule"
        ),
        PainPointSolution(
            id = 4,
            frustration = "Generic online diet charts with unattainable foods",
            solution = "Practical, Pune-friendly meal plans tailored to Indian diets and real everyday food options.",
            iconName = "rice_bowl"
        ),
        PainPointSolution(
            id = 5,
            frustration = "High membership fees with zero personal accountability",
            solution = "Transparent cost calculator, zero hidden charges, and monthly InBody progress scans to ensure results.",
            iconName = "savings"
        )
    )

    val TESTIMONIALS = listOf(
        Testimonial(
            id = 1,
            name = "Rohan Deshmukh",
            locality = "Baner, Pune",
            result = "Lost 12 kg in 90 Days",
            review = "PowerZone transformed my fitness completely! Under Sameer sir and team's personal training, I shed 12 kg of stubborn fat in 3 months. The equipment quality in Sai Complex Baner is top notch!"
        ),
        Testimonial(
            id = 2,
            name = "Ananya Sharma",
            locality = "Balewadi, Pune",
            result = "Gained Energy & Toned Core",
            review = "The 10 AM to 12 PM Ladies Batch is an absolute blessing for women in Balewadi & Baner. Very hygienic environment, polite trainers, and energetic Zumba sessions every week!"
        ),
        Testimonial(
            id = 3,
            name = "Vikram Kulkarni",
            locality = "Aundh, Pune",
            result = "+6 kg Muscle Gain",
            review = "I used to be a hardgainer. The 180-Day Muscle Building Program helped me put on 6 kg of solid muscle mass. Best free weight section and power racks near Baner Road signal."
        ),
        Testimonial(
            id = 4,
            name = "Priya Patil",
            locality = "Pashan, Pune",
            result = "Flexibility & Posture Fixed",
            review = "The combination of CrossFit functional training and weekend Yoga restored my lower back posture after long IT desk hours. The steam room after heavy leg day is pure bliss!"
        )
    )

    val GALLERY_ITEMS = listOf(
        GalleryItem("g1", "Main Gym Floor & Heavy Power Racks", "Gym Floor", "Spacious 4,000 sq.ft zone with Olympic barbells, power cages, and dumbbells up to 50kg.", "Free Weights"),
        GalleryItem("g2", "High-Performance Cardio Zone", "Cardio Zone", "Commercial treadmills, spin bikes, rowers, and elliptical trainers with personal display monitors.", "Cardio"),
        GalleryItem("g3", "1-on-1 Personal Training Area", "Personal Training", "Dedicated functional space for biomechanically targeted personal training and athletic drills.", "Personal Training"),
        GalleryItem("g4", "Group Class Studio (Zumba & Yoga)", "Group Studio", "Acoustically tuned studio with wooden shock-absorbent flooring for Zumba and Yoga.", "Group Classes"),
        GalleryItem("g5", "Wall of Fame & Transformations", "Transformations", "Inspiring member transformation photos, before/after measurements, and competition trophies.", "Results"),
        GalleryItem("g6", "Luxury Steam Room & Locker Zone", "Steam Room", "Hygiene-first steam bath facilities and key-secured personal lockers for post-workout recovery.", "Recovery"),
        GalleryItem("g7", "Mindful Yoga & Stretch Studio", "Yoga Studio", "Quiet ambient lit hall designed for breathwork, mobility drills, and guided meditation.", "Mindfulness"),
        GalleryItem("g8", "Dedicated Ladies Batch Zone", "Ladies Batch", "Exclusive 10:00 AM - 12:00 PM batch setup ensuring privacy, female trainers, and tailored workouts.", "Ladies Special")
    )

    val PROCESS_STEPS = listOf(
        Pair("01. Book Free Trial", "Claim your 3-day complimentary pass online or via WhatsApp with zero obligation."),
        Pair("02. Fitness Assessment", "Undergo InBody composition analysis, mobility screening & baseline testing."),
        Pair("03. Custom Plan", "Receive a personalized workout split and Pune-friendly macro nutrition plan."),
        Pair("04. Train & Transform", "Execute your workouts under certified guidance and track progress monthly.")
    )

    val SAMPLE_STORIES = listOf(
        StoryReelItem("story_1", "Member PR: 180kg Deadlift", "HEAVY LIFT", "Strength", "Rohan hit 180kg raw deadlift at Baner floor!", "Shattered his personal best after 12 weeks of structured strength coaching under Sameer sir."),
        StoryReelItem("story_2", "Ladies Batch Vibe", "10 AM BATCH", "Ladies Special", "High-energy Zumba & Core circuit", "Full house at 10 AM batch! Fun workouts, supportive female trainers, and high energy beats."),
        StoryReelItem("story_3", "Steam Bath Spa Tour", "RECOVERY", "Facilities", "Post-leg day steam room relaxation", "Hygienic eucalyptus-infused steam session in Sai Complex to accelerate muscle recovery."),
        StoryReelItem("story_4", "InBody Composition Scan", "RESULTS", "Assessment", "Lost 4.2% body fat in 30 days", "Ananya completed her 30-day re-assessment scan showing pure muscle gain and fat loss."),
        StoryReelItem("story_5", "Morning HIIT Circuit", "6:30 AM", "Cardio", "Endurance & Agility drills", "Sweat-inducing kettlebell and battlerope workout to kickstart your Baner workday.")
    )

    val SAMPLE_AMENITIES = listOf(
        AmenityItem("am_1", "Heavy Hammer Strength Floor", "4,000 SQ.FT", "Olympic Barbells, Cages & Heavy Dumbbells", "Engineered for bodybuilders & powerlifters. Olympic bench press stations, squat racks, hack squat machine, and dumbbells up to 50 kg.", listOf("Olympic Squat Racks", "Dumbbells 2.5kg to 50kg", "Rubberized Anti-Slip Flooring")),
        AmenityItem("am_2", "Dedicated Ladies Batch Studio", "10 AM - 12 PM", "Comfortable, Private & Female-Led", "A safe and empowering environment designed specifically for women in Baner, with female fitness trainers and tailored routines.", listOf("Female Certified Trainers", "Private Studio Setup", "Zumba & Core Focus")),
        AmenityItem("am_3", "Eucalyptus Steam Bath & Lockers", "HYGIENE FIRST", "Deep Muscle Recovery & Detox", "Relax your muscles after an intense workout. Sanitize-checked daily with private changing cubicles and key-secured lockers.", listOf("Eucalyptus Infused Steam", "Secured Personal Lockers", "Hot & Cold Showers")),
        AmenityItem("am_4", "High-Performance Cardio Deck", "20+ STATIONS", "Treadmills, Spin Bikes & Ellipticals", "Commercial-grade fitness equipment with digital monitors to keep heart rate in optimal fat-burning zones.", listOf("Touchscreen Treadmills", "Indoor Cycling Spin Bikes", "Cross Trainers & Rowers")),
        AmenityItem("am_5", "InBody Body Composition Analyzer", "PRECISION DATA", "Segmental Muscle & Fat Analysis", "Medical-grade bio-impedance scanner tracking exact visceral fat, skeletal muscle mass, and metabolic rate.", listOf("2-Minute Full Scan", "Visceral Fat Tracking", "Monthly Progress Reports")),
        AmenityItem("am_6", "In-House Nutrition & Shake Bar", "FUEL & RECOVER", "Post-Workout Whey & Isotonic Drinks", "Fresh protein smoothies, BCAA slushes, and Pune-tailored macro snacks to fuel your post-workout window.", listOf("Fresh Whey Smoothies", "Zero-Sugar Electrolytes", "BCAA Recovery Drinks"))
    )

    val SAMPLE_WORKOUT_SPLITS = listOf(
        WorkoutSplitItem("ws_1", "Push / Pull / Legs (PPL)", "Hypertrophy & Athletic Strength", "6 Days / Week", "Muscle Building & Definition", listOf("Incline Dumbbell Press (4x10)", "Barbell Back Squat (4x8)", "Lat Pulldowns (4x12)", "Overhead Shoulder Press (3x10)", "Romanian Deadlifts (4x10)"), "Chest, Back, Legs & Arms"),
        WorkoutSplitItem("ws_2", "Ladies Tone & Functional Circuit", "Fat Burn, Core Strength & Posture", "4-5 Days / Week", "Body Toning & Weight Loss", listOf("Goblet Squats & Glute Bridges (4x15)", "Dumbbell Rows & Lat Raises (3x12)", "Core Plank & Mountain Climbers (4x45s)", "Zumba Cardio Burn (30 min)", "Mobility & Hip Flexor Stretches"), "Core, Glutes, Legs & Posture"),
        WorkoutSplitItem("ws_3", "Power Bodybuilding Split", "Maximal Strength & Heavy Mass", "5 Days / Week", "Hardcore Mass & Power", listOf("Conventional Heavy Deadlift (5x5)", "Barbell Bench Press (5x5)", "Weighted Dips & Pullups (4x8)", "Heavy Barbell Shrugs (4x12)", "Incline Hammer Curl (4x10)"), "Full Body Strength & Density"),
        WorkoutSplitItem("ws_4", "Fat Loss HIIT & Functional Tabata", "Calorie Shred & Metabolic Blast", "4 Days / Week", "Rapid Weight Loss & Stamina", listOf("Kettlebell Swings (4x40s)", "Battlerope Waves (4x30s)", "Box Jumps & Burpees (4x12)", "Sled Push & Rowing Sprints", "Abs Leg Raises & Russian Twists"), "Cardiovascular & Metabolic Shred")
    )

    val SAMPLE_NUTRITION_PLANS = listOf(
        NutritionPlanItem("nut_1", "Indian High-Protein Muscle Plan", "Muscle Gain", "2,400 kcal", "150g", "250g", "60g", listOf("Breakfast: 4 Egg Whites / Paneer Bhurji + Oats", "Lunch: Brown Rice, Chicken/Soya Curry, Dal, Curd", "Pre-Workout: Banana + Peanut Butter Toast", "Post-Workout: Whey Protein Shake + Almonds", "Dinner: Roti, Paneer Tikka / Grilled Fish, Salad"), "Optimized for Indian dietary preferences with high bioavailability proteins."),
        NutritionPlanItem("nut_2", "Baner Fat Loss & Deficit Meal Plan", "Fat Loss", "1,700 kcal", "130g", "150g", "45g", listOf("Breakfast: Moong Dal Chilla / Omelette + Green Tea", "Lunch: Multigrain Roti, Sprouts Salad, Grilled Chicken / Paneer", "Evening Snack: Roasted Chana / Makhana", "Dinner: Mixed Veg Soup, Tofu / Fish Curry, Cucumber"), "Calorie-controlled nutrient-dense plan engineered for consistent weight reduction."),
        NutritionPlanItem("nut_3", "Vegetarian Fitness & Protein Meal Plan", "Veg Pure", "2,000 kcal", "125g", "210g", "55g", listOf("Breakfast: Paneer Stuffed Besan Chilla + Protein Shake", "Lunch: Rajma / Chole, Quinoa or Brown Rice, Curd", "Snack: Boiled Peanut Chat + Sprouts", "Dinner: Soya Chunk Gravy, Bajra Roti, Cucumber Salad"), "100% Vegetarian diet supplying complete amino acid profiles.")
    )
}

